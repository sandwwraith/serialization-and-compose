import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
//    id("kotlin-android-extensions")
    kotlin("plugin.serialization")
}

group = "kotlinx.testing"
version = "1.0"

repositories {
    mavenCentral()
}

val serialization_runtime_version: String by project

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_runtime_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api(compose.foundation)
                api(compose.material)
                api("androidx.appcompat:appcompat:1.2.0")
                api("androidx.core:core-ktx:1.3.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }
        val desktopAndroidCommon by sourceSets.creating  {
            dependsOn(commonMain)
            dependencies {
                api(compose.foundation)
                api(compose.material)
            }
            desktopMain.dependsOn(this)
            androidMain.dependsOn(this)
        }
        val jsMain by getting {
            dependencies {
                api(compose.web.core)
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
