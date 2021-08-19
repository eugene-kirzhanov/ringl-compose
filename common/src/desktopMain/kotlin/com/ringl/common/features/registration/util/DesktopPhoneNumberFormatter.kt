package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

actual fun getPhoneNumberFormatter(locale: Locale): PhoneNumberFormatter = GooglePhoneNumberFormatter(locale)