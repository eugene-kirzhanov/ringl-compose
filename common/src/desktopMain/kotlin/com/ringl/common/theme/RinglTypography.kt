package com.ringl.common.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val robotoFontFamily: FontFamily = FontFamily(
    Font(
        resource = "font/Roboto-Regular.ttf",
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = "font/Roboto-Bold.ttf",
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    )
)
