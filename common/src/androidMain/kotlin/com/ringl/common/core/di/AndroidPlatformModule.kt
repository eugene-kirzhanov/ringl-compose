package com.ringl.common.core.di

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger
import org.koin.dsl.module

actual fun platformModule() = module {
    single<Logger> { LogcatLogger() }
}