import java.nio.file.Files
import java.nio.file.Path

rootProject.name = "rsmod"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    plugins {
        kotlin("jvm") version "1.9.0"
    }
}

include(
    "config",
    "game",
    "log",
    "plugins",
    "app"
)

includePlugins(project(":plugins"))

fun includePlugins(pluginProject: ProjectDescriptor) {
    val pluginPath = pluginProject.projectDir.toPath()
    Files.walk(pluginPath).forEach {
        if (!Files.isDirectory(it)) {
            return@forEach
        }
        searchPlugin(pluginProject.name, pluginPath, it)
    }
}

fun searchPlugin(parentName: String, pluginRoot: Path, currentPath: Path) {
    val hasBuildFile = Files.exists(currentPath.resolve("build.gradle.kts"))
    if (!hasBuildFile) {
        return
    }
    val relativePath = pluginRoot.relativize(currentPath)
    val pluginName = relativePath.toString().replace(File.separator, ":")
    if(pluginName == "info" || pluginName == "cache" || pluginName == "types")
        return
    include("$parentName:$pluginName")
}
