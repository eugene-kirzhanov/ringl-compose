package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale

expect fun getPhoneNumberValidator(locale: Locale): PhoneNumberValidator

interface PhoneNumberValidator {

    fun validatePhoneNumber(countryCode: String, phoneNumber: String): Boolean

}

internal class CommonPhoneNumberValidator(locale: Locale) : PhoneNumberValidator {

    private val platformPhoneNumberValidator = getPhoneNumberValidator(locale)

    override fun validatePhoneNumber(countryCode: String, phoneNumber: String): Boolean {
        return platformPhoneNumberValidator.validatePhoneNumber(countryCode, phoneNumber)
    }

}
