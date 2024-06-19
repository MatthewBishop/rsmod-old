plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.game)
    implementation(libs.rsmodEvents)
    implementation(libs.rsmodScripts)
    implementation(libs.rsmodTypes)
    implementation(projects.plugins.api)
    implementation(projects.plugins.content.gameframe)
    implementation(libs.guice)
    implementation(libs.kotlinScriptRuntime)
}
