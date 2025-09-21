plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
	alias(libs.plugins.kotlin.jpa)
}

group = "com.vincicent"
version = "0.0.1-SNAPSHOT"
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