object Versions {
    const val androidMinSdk = 21
    const val androidCompileSdk = 30
    const val androidTargetSdk = 30

    const val kotlin = "1.5.21"
}

object Deps {
    object Gradle {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        const val compose = "org.jetbrains.compose:compose-gradle-plugin:1.0.0-alpha4-build318"
    }

    object Kotlinx {
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val appCompat = "androidx.appcompat:appcompat:1.4.0-alpha03"
        const val coreKtx = "androidx.core:core-ktx:1.7.0-alpha01"
    }

    object Koin {
        private const val version = "3.1.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Log {
        const val kermit = "co.touchlab:kermit:0.1.9"
    }

    const val libPhoneNumber = "com.googlecode.libphonenumber:libphonenumber:8.12.30"
}