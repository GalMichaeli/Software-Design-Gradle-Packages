plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`

}

group = "il.ac.technion.cs.sd"
version = "1.0"
artifactid = "software-design-gradle-packages"

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
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
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