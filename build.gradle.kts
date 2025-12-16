import org.gradle.api.publish.maven.MavenPublication

plugins {
    id("java")
    id("maven-publish")
}

group = "com.rupia.kafka"
version = "1.0.5"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "kafka-event"
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ronem123/rupia-kafka-event")
            credentials {
                username = project.findProperty("gpr.user").toString()
                password = project.findProperty("gpr.token").toString()
            }
        }
    }
}
