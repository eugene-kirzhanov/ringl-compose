package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

internal interface PhoneNumberUtils {

    fun formatNumber(countryCode: String, phoneNumber: String): String

    fun isValidPhoneNumber(countryCode: String, phoneNumber: String): Boolean

}

internal class CommonPhoneNumberUtils(
    locale: Locale
) : PhoneNumberUtils by getPhoneNumberUtils(locale.region)

internal expect fun getPhoneNumberUtils(region: String): PhoneNumberUtils
