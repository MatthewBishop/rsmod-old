plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.rsmodBuffer)
    implementation(projects.config)
    implementation(projects.game)
    implementation(projects.plugins.api)
    implementation(libs.rsmodTypes)
    implementation(projects.plugins.typesGenerated)
    implementation(libs.rsmodToml)
    implementation(libs.clikt)
    implementation(libs.guice)
    implementation(libs.kotlinPoet)
    implementation(libs.openrs2Cache)
}

tasks.register<JavaExec>("generateTypeNames") {
    workingDir = rootProject.projectDir
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("org.rsmod.plugins.types.gen.GenerateTypesCommandKt")
}
