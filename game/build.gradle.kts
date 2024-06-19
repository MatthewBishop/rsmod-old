plugins {
    kotlin("jvm")
}

dependencies {
    implementation(projects.config)
    implementation(libs.rsmodBuffer)
    implementation(projects.log)
    implementation(libs.rsmodToml)
    implementation(libs.rsmodCoroutines)
    implementation(libs.rsmodEvents)
    implementation(libs.rsmodMap)
    implementation(libs.rsmodProtocol)
    implementation(libs.clikt)
    implementation(libs.guava)
    implementation(libs.guice)
    implementation(libs.inlineLogger)
    implementation(libs.kotlinCoroutinesCore)
    implementation(libs.logback)
    implementation(libs.nettyTransport)
    implementation(libs.openrs2Crypto)
}
