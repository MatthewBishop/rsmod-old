plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.game)
    implementation(libs.rsmodEvents)
    implementation(libs.rsmodScripts)
    implementation(projects.plugins.api)
    implementation(libs.rsmodTypes)
    implementation(libs.guice)
    implementation(libs.kotlinScriptRuntime)
}
