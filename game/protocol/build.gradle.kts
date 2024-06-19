version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.nettyTransport)
    implementation(libs.nettyCodecCore)
    implementation(libs.openrs2Crypto)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Protocol")
            description.set(
                """
                A module providing a comprehensive protocol handling system for encoding and decoding packets,
                utilizing Netty and supporting various packet types in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
