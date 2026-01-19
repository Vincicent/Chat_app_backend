plugins {
    id("java-library")
    id("chatapp.kotlin-common")
}

group = "com.vincicent"
version = "unspecified"
description = "Chat app backend - common module"

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    api(libs.kotlin.reflect)
    api(libs.jackson.module.kotlin)

	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}