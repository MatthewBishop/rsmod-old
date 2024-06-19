plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.config)
    implementation(projects.game)
    implementation(libs.rsmodMap)
    implementation(libs.rsmodScripts)
    implementation(libs.rsmodJson)
    implementation(projects.plugins.store)
    implementation(libs.guice)
    implementation(libs.jacksonDatabind)
}
