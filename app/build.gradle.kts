plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.config)
    implementation(projects.game)
    implementation(libs.rsmodEvents)
    implementation(libs.rsmodScripts)
    implementation(projects.log)
    implementation(libs.guice)
    implementation(libs.logback)
    implementation(libs.inlineLogger)
    implementation(libs.clikt)
    findPlugins(projects.plugins).forEach {
        implementation(it)
    }
}

fun findPlugins(pluginProject: ProjectDependency): List<Project> {
    val plugins = mutableListOf<Project>()
    pluginProject.dependencyProject.subprojects.forEach {
        if (it.buildFile.exists()) {
            plugins += it
        }
    }
    return plugins
}
