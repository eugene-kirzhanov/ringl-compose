import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        val commonMain by getting
        val jvmMain by creating
        val androidMain by getting
        val desktopMain by getting

        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material)
        }

        jvmMain.apply {
            dependsOn(commonMain)
            dependencies {
                implementation("com.googlecode.libphonenumber:libphonenumber:8.12.30")
            }
        }

        androidMain.apply {
            dependsOn(jvmMain)
            dependencies {
                api("androidx.appcompat:appcompat:1.4.0-alpha03")
                api("androidx.core:core-ktx:1.7.0-alpha01")
            }
        }

        desktopMain.apply {
            dependsOn(jvmMain)
            dependencies {
                api(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}