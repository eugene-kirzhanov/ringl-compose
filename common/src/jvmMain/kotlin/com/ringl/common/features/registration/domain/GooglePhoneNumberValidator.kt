package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

class GooglePhoneNumberValidator(
    private val locale: Locale
) : PhoneNumberValidator {

    override fun validatePhoneNumber(countryCode: String, phoneNumber: String): Boolean {
        val countryCodeDigits = countryCode.filter { it.isDigit() }
        val phoneNumberDigits = phoneNumber.filter { it.isDigit() }
        val fullNumber = "+$countryCodeDigits$phoneNumberDigits"
        if (fullNumber.isEmpty()) return false
        return try {
            val phoneUtil = PhoneNumberUtil.getInstance()
            val parsed = phoneUtil.parse(fullNumber, locale.region)
            phoneUtil.isValidNumber(parsed)
        } catch (e: NumberParseException) {
            false
        }
    }

}