plugins {
    kotlin("jvm")
}

dependencies {
    api(projects.game)
    api(libs.rsmodEvents)
    api(libs.rsmodProtocol)
    implementation(projects.game)
    implementation(libs.junitApi)
    implementation(libs.junitEngine)
}
