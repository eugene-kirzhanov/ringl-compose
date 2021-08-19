package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale
import com.ringl.common.features.registration.util.CommonPhoneNumberUtils

internal interface PhoneNumberValidator {

    fun validatePhoneNumber(countryCode: String, phoneNumber: String): Boolean

}

internal class CommonPhoneNumberValidator(locale: Locale) : PhoneNumberValidator {

    private val phoneNumberUtils = CommonPhoneNumberUtils(locale)

    override fun validatePhoneNumber(countryCode: String, phoneNumber: String): Boolean {
        return phoneNumberUtils.isValidPhoneNumber(countryCode, phoneNumber)
    }

}
