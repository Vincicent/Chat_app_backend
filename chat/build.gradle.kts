plugins {
	id("java-library")
    id("chatapp.spring-boot-service")
    kotlin("plugin.jpa")
}

group = "com.vincicent"
version = "unspecified"
description = "Chat app backend - chat module"

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(projects.common)

    implementation(libs.spring.boot.starter.validation)

    implementation(libs.spring.boot.starter.data.jpa)
    runtimeOnly(libs.postgresql)

	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}