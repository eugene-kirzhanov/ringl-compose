package com.ringl.common.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
internal actual fun imageLogo(): Painter = painterResource("images/ringl_logo.png")
