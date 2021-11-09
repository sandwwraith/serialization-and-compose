buildscript {
    val kotlin_version: String by project
    val compose_version: String by project
    val android_tools_version: String by project

    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
        classpath("org.jetbrains.compose:compose-gradle-plugin:$compose_version")
        classpath("com.android.tools.build:gradle:$android_tools_version")
    }
}

group = "kotlinx.testing"
version = "1.0"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}