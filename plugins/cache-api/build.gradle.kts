plugins {
    kotlin("jvm")
}

dependencies {
    api(projects.plugins.cache)
    implementation(projects.game.config)
    implementation(projects.game.map)
    implementation(projects.game.pathfinder)
    implementation(projects.json)
    implementation(projects.plugins.types)
    implementation(projects.toml)
    implementation(libs.nettyBuffer)
    implementation(libs.openrs2Cache)
    implementation(libs.openrs2Buffer)
}
