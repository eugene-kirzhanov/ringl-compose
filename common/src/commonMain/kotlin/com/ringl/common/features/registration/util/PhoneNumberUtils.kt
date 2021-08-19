package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

internal expect fun getPhoneNumberUtils(locale: Locale): PhoneNumberUtils

internal interface PhoneNumberUtils {

    fun formatNumber(countryCode: String, phoneNumber: String): String

    fun isValidPhoneNumber(countryCode: String, phoneNumber: String): Boolean

}

internal class CommonPhoneNumberUtils(
    locale: Locale
) : PhoneNumberUtils {

    private val platformPhoneNumberUtils = getPhoneNumberUtils(locale)

    override fun formatNumber(countryCode: String, phoneNumber: String): String {
        return platformPhoneNumberUtils.formatNumber(countryCode, phoneNumber)
    }

    override fun isValidPhoneNumber(countryCode: String, phoneNumber: String): Boolean {
        return platformPhoneNumberUtils.isValidPhoneNumber(countryCode, phoneNumber)
    }

}