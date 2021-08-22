package com.ringl.common.compose.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val cornerSize8 = CornerSize(8.dp)

@Composable
internal fun inputShape() = MaterialTheme.shapes.small.copy(
    topStart = cornerSize8,
    topEnd = cornerSize8,
    bottomStart = ZeroCornerSize,
    bottomEnd = ZeroCornerSize
)

@Composable
internal fun buttonShape() = MaterialTheme.shapes.small.copy(
    topStart = cornerSize8,
    topEnd = cornerSize8,
    bottomStart = cornerSize8,
    bottomEnd = cornerSize8
)