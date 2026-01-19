plugins {
    id("java-library")
    id("chatapp.spring-boot-service")
    kotlin("plugin.jpa")
}

group = "com.vincicent"
version = "unspecified"
description = "Chat app backend - notification module"

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(projects.common)

	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}