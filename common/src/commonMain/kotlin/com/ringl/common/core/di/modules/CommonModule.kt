package com.ringl.common.core.di.modules

import co.touchlab.kermit.Kermit
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun commonModule() = module {
    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }

    single {
        Kermit(defaultTag = "Ringl", loggerList = listOf(get()))
    }
}