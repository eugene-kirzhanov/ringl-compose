package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

expect fun getPhoneNumberFormatter(locale: Locale): PhoneNumberFormatter

interface PhoneNumberFormatter {

    fun formatPhoneNumber(countryCode: String, phoneNumber: String): String

}

internal class CommonPhoneNumberFormatter(
    locale: Locale
) : PhoneNumberFormatter {

    private val platformPhoneNumberFormatter = getPhoneNumberFormatter(locale)

    override fun formatPhoneNumber(countryCode: String, phoneNumber: String): String {
        return platformPhoneNumberFormatter.formatPhoneNumber(countryCode, phoneNumber)
    }

}