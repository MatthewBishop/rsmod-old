plugins {
    kotlin("jvm")
}

dependencies {
    api(libs.rsmodMap)
    api(libs.rsmodPathfinder)
    api(projects.plugins.testing.assertions)
    implementation(libs.rsmodScripts)
    implementation(projects.log)
    implementation(projects.plugins.api)
    implementation(projects.plugins.cacheApi)
    implementation(libs.guice)
    implementation(libs.inlineLogger)
    implementation(libs.junitApi)
    implementation(libs.junitEngine)
    implementation(libs.logback)
    implementation(libs.openrs2Cache)
}

tasks.test {
    systemProperty("junit.jupiter.extensions.autodetection.enabled", false)
}
