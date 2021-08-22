package com.ringl.common.core.di.modules

import co.touchlab.kermit.Kermit
import org.koin.dsl.module

fun commonModule() = module {
    single {
        Kermit(defaultTag = "Ringl", loggerList = listOf(get()))
    }
}