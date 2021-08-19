package com.ringl

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.ringl.common.App
import com.ringl.common.resources.strings
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

//private val MIN_WIDTH = 360.dp
//private val MIN_HEIGHT = 640.dp

@ExperimentalMaterialApi
fun main() = application {
    val state = rememberWindowState(width = 640.dp, height = 700.dp)
    Window(
        icon = painterResource("app_icon.png"),
        title = strings().common.appName,
        state = state,
        resizable = true,
        onCloseRequest = ::exitApplication
    ) {
        DesktopMaterialTheme {
            App()
        }
        LaunchedEffect(state) {
            snapshotFlow { state.size }
                .onEach {
                    // todo не дать уменьшить размер окна меньше чем надо
//                    val width = max(MIN_WIDTH.value, size.width.value).dp
//                    val height = max(MIN_HEIGHT.value, size.height.value).dp
//                    if (width != size.width || height != size.height) {
//                        state.size = state.size.copy(width, height)
//                    }
                }
                .launchIn(this)
        }
    }
}
