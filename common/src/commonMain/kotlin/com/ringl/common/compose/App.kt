package com.ringl.common.compose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.ringl.features.registration.compose.RegistrationScreen

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun App() {
    RegistrationScreen()
}
