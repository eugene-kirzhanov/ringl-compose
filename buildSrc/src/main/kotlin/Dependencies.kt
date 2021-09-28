object Versions {
    const val androidMinSdk = 21
    const val androidCompileSdk = 31
    const val androidTargetSdk = 31

    const val kotlin = "1.5.31"
}

object Deps {
    object Kotlin {
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    }

    object Compose {
        const val plugin = "org.jetbrains.compose:compose-gradle-plugin:1.0.0-alpha4-build362"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0-alpha02"
        const val appCompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val coreKtx = "androidx.core:core-ktx:1.7.0-beta01"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-alpha01"
    }

    object Android {
        const val material = "com.google.android.material:material:1.5.0-alpha03"
    }

    object Koin {
        private const val version = "3.1.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Log {
        const val kermit = "co.touchlab:kermit:0.1.9"
    }

    const val libPhoneNumber = "com.googlecode.libphonenumber:libphonenumber:8.12.33"
}