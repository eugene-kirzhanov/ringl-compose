package com.ringl.features.registration.core.util

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber

internal class GooglePhoneNumberUtils : PhoneNumberUtils {

    override fun formatNumber(countryCode: String, phoneNumber: String, regionCode: String): String {
        val trimmedPhoneNumber = phoneNumber.trim()
        if (trimmedPhoneNumber.isEmpty()) return ""
        return try {
            val parsed = parsePhoneNumber(countryCode, trimmedPhoneNumber, regionCode)
            val formatted = PhoneNumberUtil.getInstance().format(parsed, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
            formatted.replace("+${parsed.countryCode}", "").trim()
        } catch (e: NumberParseException) {
            trimmedPhoneNumber
        }
    }

    override fun isValidPhoneNumber(countryCode: String, phoneNumber: String, regionCode: String): Boolean {
        return try {
            val parsed = parsePhoneNumber(countryCode, phoneNumber, regionCode)
            PhoneNumberUtil.getInstance().isValidNumber(parsed)
        } catch (e: NumberParseException) {
            false
        }
    }

    private fun parsePhoneNumber(countryCode: String, phoneNumber: String, regionCode: String): Phonenumber.PhoneNumber {
        val countryCodeDigits = countryCode.filter { it.isDigit() }
        val phoneNumberDigits = phoneNumber.filter { it.isDigit() }
        val fullNumber = "+$countryCodeDigits$phoneNumberDigits"
        val phoneUtil = PhoneNumberUtil.getInstance()
        return phoneUtil.parse(fullNumber, regionCode)
    }

}