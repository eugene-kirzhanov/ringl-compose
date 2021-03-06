import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(Deps.Koin.core)
                api(Deps.Log.kermit)
                implementation(Deps.Coroutines.core)
            }
        }
        named("androidMain") {
            dependencies {
                api(Deps.AndroidX.appCompat)
                api(Deps.AndroidX.coreKtx)
                implementation(Deps.libPhoneNumber)
            }
        }
        named("desktopMain") {
            dependencies {
                api(compose.desktop.common)
                implementation(Deps.libPhoneNumber)
            }
        }
    }
}

android {
    compileSdk = Versions.androidCompileSdk

    defaultConfig {
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk
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