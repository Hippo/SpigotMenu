plugins {
    java
    id("maven-publish")
}

group = "rip.hippo"
version = "1.0.8"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.8-R0.1-SNAPSHOT")
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}