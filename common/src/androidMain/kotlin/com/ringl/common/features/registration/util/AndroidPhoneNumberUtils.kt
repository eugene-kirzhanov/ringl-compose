package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

internal actual fun getPhoneNumberUtils(locale: Locale): PhoneNumberUtils = GooglePhoneNumberUtils(locale)