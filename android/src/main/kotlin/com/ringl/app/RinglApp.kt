package com.ringl.app

import android.app.Application
import com.ringl.app.di.appModule
import com.ringl.common.core.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class RinglApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@RinglApp)
            modules(
                appModule
            )
        }
    }

}