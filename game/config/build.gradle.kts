plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.toml)
    implementation(projects.game.map)
    implementation(libs.guice)
    implementation(libs.jacksonKotlin)
}
