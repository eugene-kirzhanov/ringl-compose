package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale
import com.ringl.common.features.registration.util.PhoneNumberUtils

internal interface PhoneNumberValidator {

    fun validatePhoneNumber(countryCode: String, phoneNumber: String, locale: Locale): Boolean

}

internal class CommonPhoneNumberValidator(
    private val phoneNumberUtils: PhoneNumberUtils
) : PhoneNumberValidator {

    override fun validatePhoneNumber(countryCode: String, phoneNumber: String, locale: Locale): Boolean {
        return phoneNumberUtils.isValidPhoneNumber(countryCode, phoneNumber, locale)
    }

}
