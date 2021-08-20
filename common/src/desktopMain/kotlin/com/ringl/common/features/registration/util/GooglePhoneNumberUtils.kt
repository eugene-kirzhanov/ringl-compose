package com.ringl.common.features.registration.util

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber

internal class GooglePhoneNumberUtils(
    private val region: String
) : PhoneNumberUtils {

    override fun formatNumber(countryCode: String, phoneNumber: String): String {
        return try {
            val parsed = parsePhoneNumber(countryCode, phoneNumber)
            val formatted = PhoneNumberUtil.getInstance().format(parsed, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
            formatted.replace("+${parsed.countryCode}", "").trim()
        } catch (e: NumberParseException) {
            phoneNumber
        }
    }

    override fun isValidPhoneNumber(countryCode: String, phoneNumber: String): Boolean {
        return try {
            val parsed = parsePhoneNumber(countryCode, phoneNumber)
            PhoneNumberUtil.getInstance().isValidNumber(parsed)
        } catch (e: NumberParseException) {
            false
        }
    }

    private fun parsePhoneNumber(countryCode: String, phoneNumber: String): Phonenumber.PhoneNumber {
        val countryCodeDigits = countryCode.filter { it.isDigit() }
        val phoneNumberDigits = phoneNumber.filter { it.isDigit() }
        val fullNumber = "+$countryCodeDigits$phoneNumberDigits"
        val phoneUtil = PhoneNumberUtil.getInstance()
        return phoneUtil.parse(fullNumber, region)
    }

}