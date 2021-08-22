package com.ringl.common.compose.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.ringl.common.R

@Composable
internal actual fun imageLogo(): Painter = painterResource(R.drawable.ringl_logo)
