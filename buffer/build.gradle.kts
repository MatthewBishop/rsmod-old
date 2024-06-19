version = "1.0.0"

plugins {
    `maven-publish`
    kotlin("jvm")
}

dependencies {
    implementation(libs.nettyBuffer)
    implementation(libs.guice)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        pom {
            packaging = "jar"
            name.set("RS Mod Buffer")
            description.set(
                """
                A module providing buffer allocation bindings using Google Guice and Netty's ByteBufAllocator
                for efficient buffer management in an RS-style game.
                """.trimIndent()
            )
        }
    }
}
