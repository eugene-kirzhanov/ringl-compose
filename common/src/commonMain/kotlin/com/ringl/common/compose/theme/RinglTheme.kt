package com.ringl.common.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
internal fun RinglTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = RinglColors(),
        content = content
    )
}