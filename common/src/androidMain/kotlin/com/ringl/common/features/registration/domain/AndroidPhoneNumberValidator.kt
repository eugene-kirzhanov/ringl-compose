package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale

actual fun getPhoneNumberValidator(locale: Locale): PhoneNumberValidator = GooglePhoneNumberValidator(locale)