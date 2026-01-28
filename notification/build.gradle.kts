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

    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.amqp)
    implementation(libs.spring.boot.starter.mail)
    implementation(libs.spring.boot.starter.thymeleaf)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.data.jpa)

    implementation(libs.firebase.admin.sdk)

    runtimeOnly(libs.postgresql)

    testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}