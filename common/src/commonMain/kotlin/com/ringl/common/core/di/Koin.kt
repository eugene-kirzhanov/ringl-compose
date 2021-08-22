package com.ringl.common.core.di

import com.ringl.common.core.di.modules.commonModule
import com.ringl.common.core.di.modules.platformModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

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
