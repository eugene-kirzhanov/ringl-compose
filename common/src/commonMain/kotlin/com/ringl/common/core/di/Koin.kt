package com.ringl.common.core.di

import co.touchlab.kermit.Kermit
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(
    appDeclaration: KoinAppDeclaration = {}
) {
    startKoin {
        appDeclaration()
        modules(
            commonModule(),
            platformModule()
        )
    }
}

internal fun commonModule() = module {
    single { createJson() }
    single {
        Kermit(
            defaultTag = "Ringl",
            loggerList = listOf(get())
        )
    }
}

internal fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
}