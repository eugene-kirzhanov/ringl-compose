package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

internal interface PhoneNumberUtils {

    fun formatNumber(countryCode: String, phoneNumber: String, locale: Locale): String

    fun isValidPhoneNumber(countryCode: String, phoneNumber: String, locale: Locale): Boolean

}
