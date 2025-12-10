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
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}