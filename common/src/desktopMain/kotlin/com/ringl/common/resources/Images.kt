package com.ringl.common.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
actual fun imageLogo(): Painter = painterResource("images/ringl_logo.png")

@Composable
actual fun iconArrowDropDown(): Painter = painterResource("images/ic_arrow_drop_down.png")
