package com.ringl.common.core.di.modules

import co.touchlab.kermit.CommonLogger
import co.touchlab.kermit.Logger
import org.koin.dsl.module

actual fun platformModule() = module {
    single<Logger> { CommonLogger() }
}