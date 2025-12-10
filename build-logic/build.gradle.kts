plugins {
    `kotlin-dsl`
    alias(libs.plugins.spring.dependency.management)
}

group = "com.vincicent"
version = "0.0.1-SNAPSHOT"
description = "Chat app backend - notification module"

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen)
    implementation(libs.spring.boot.gradle.plugin)
}