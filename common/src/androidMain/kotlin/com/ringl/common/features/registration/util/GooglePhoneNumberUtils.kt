package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber

internal class GooglePhoneNumberUtils : PhoneNumberUtils {

    override fun formatNumber(countryCode: String, phoneNumber: String, locale: Locale): String {
        return try {
            val parsed = parsePhoneNumber(countryCode, phoneNumber, locale)
            val formatted = PhoneNumberUtil.getInstance().format(parsed, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
            formatted.replace("+${parsed.countryCode}", "").trim()
        } catch (e: NumberParseException) {
            phoneNumber
        }
    }

    override fun isValidPhoneNumber(countryCode: String, phoneNumber: String, locale: Locale): Boolean {
        return try {
            val parsed = parsePhoneNumber(countryCode, phoneNumber, locale)
            PhoneNumberUtil.getInstance().isValidNumber(parsed)
        } catch (e: NumberParseException) {
            false
        }
    }

    private fun parsePhoneNumber(countryCode: String, phoneNumber: String, locale: Locale): Phonenumber.PhoneNumber {
        val countryCodeDigits = countryCode.filter { it.isDigit() }
        val phoneNumberDigits = phoneNumber.filter { it.isDigit() }
        val fullNumber = "+$countryCodeDigits$phoneNumberDigits"
        val phoneUtil = PhoneNumberUtil.getInstance()
        return phoneUtil.parse(fullNumber, locale.region)
    }

}