package com.ringl.common.features.registration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ringl.common.resources.imageLogo
import com.ringl.common.resources.strings
import com.ringl.common.theme.robotoFontFamily

@Composable
internal fun RegistrationHeader() {
    Spacer(Modifier.height(40.dp))
    Image(
        painter = imageLogo(),
        contentDescription = null,
        modifier = Modifier.size(80.dp)
    )
    Spacer(Modifier.height(24.dp))
    Text(
        text = strings().registration.title,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.41.sp,
        color = Color.Black
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = strings().registration.subtitle,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        letterSpacing = (-0.24).sp,
        color = Color.Black
    )
}
