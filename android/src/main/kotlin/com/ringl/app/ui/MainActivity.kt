package com.ringl.app.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ringl.common.compose.App

class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MaterialTheme {
                App()
            }
        }
    }

}