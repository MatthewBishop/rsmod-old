plugins {
    kotlin("jvm")
}

dependencies {
    api(libs.rsmodCache)
    implementation(libs.rsmodConfig)
    implementation(libs.rsmodMap)
    implementation(libs.rsmodPathfinder)
    implementation(libs.rsmodJson)
    implementation(libs.rsmodTypes)
    implementation(libs.nettyBuffer)
    implementation(libs.openrs2Cache)
    implementation(libs.openrs2Crypto)
    implementation(libs.openrs2Buffer)
}
