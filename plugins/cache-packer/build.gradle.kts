plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.rsmodBuffer)
    implementation(projects.game)
    implementation(projects.plugins.api)
    implementation(libs.rsmodCache)
    implementation(libs.rsmodTypes)
    implementation(libs.rsmodToml)
    implementation(libs.clikt)
    implementation(libs.inlineLogger)
    implementation(libs.openrs2Cache)
}

tasks.register<JavaExec>("packConfigs") {
    workingDir = rootProject.projectDir
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("org.rsmod.plugins.cache.packer.ConfigPackerCommandKt")
}
