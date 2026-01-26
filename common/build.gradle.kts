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

    implementation(libs.spring.boot.starter.amqp)
    implementation(libs.spring.boot.starter.security)

	testImplementation(kotlin("test"))

    implementation(libs.jwt.api)
    implementation(libs.jwt.impl)
    implementation(libs.jwt.jackson)
}

tasks.test {
	useJUnitPlatform()
}