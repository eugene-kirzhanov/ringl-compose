package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

class GooglePhoneNumberFormatter(
    private val locale: Locale
) : PhoneNumberFormatter {

    override fun formatPhoneNumber(countryCode: String, phoneNumber: String): String {
        val countryCodeDigits = countryCode.filter { it.isDigit() }
        val phoneNumberDigits = phoneNumber.filter { it.isDigit() }
        val fullNumber = "+$countryCodeDigits$phoneNumberDigits"
        if (fullNumber.isEmpty()) return ""
        return try {
            val phoneUtil = PhoneNumberUtil.getInstance()
            val parsed = phoneUtil.parse(fullNumber, locale.region)
            val formatted = phoneUtil.format(parsed, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
            formatted.replace("+$countryCodeDigits", "").trim()
        } catch (e: NumberParseException) {
            phoneNumberDigits
        }
    }

}