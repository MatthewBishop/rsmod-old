plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.buffer)
    implementation(projects.game.config)
    implementation(projects.plugins.api)
    implementation(projects.plugins.types)
    implementation(projects.plugins.typesGenerated)
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
