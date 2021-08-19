package com.ringl.common.features.registration.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun SelectCountryCodeScreen(
    selectedCountryCode: String,
    onCountryCodeSelected: (selectedCountryCode: String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Hello, $selectedCountryCode")
    }
}