package com.ringl.common.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.ringl.common.R

@Composable
actual fun imageLogo(): Painter = painterResource(R.drawable.ringl_logo)

@Composable
actual fun iconArrowDropDown(): Painter = painterResource(R.drawable.ic_arrow_drop_down)
