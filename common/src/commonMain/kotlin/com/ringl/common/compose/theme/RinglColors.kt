package com.ringl.common.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFF1791AC)
val primaryVariantColor = Color(0xFF0C6E84)

@Composable
internal fun RinglColors() = MaterialTheme.colors.copy(
    primary = primaryColor,
    primaryVariant = primaryVariantColor
)