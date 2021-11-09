import org.jetbrains.compose.compose

plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
}

group = "kotlinx.testing"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))

    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)

    implementation("androidx.activity:activity-compose:1.3.0-alpha06")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "kotlinx.testing.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
