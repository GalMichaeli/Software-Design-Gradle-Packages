plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`

}

group = "il.ac.technion.cs.sd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/GalMichaeli/Software-Design-Gradle-Packages")
            credentials {
                username = "GalMichaeli"
                password = "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"
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}