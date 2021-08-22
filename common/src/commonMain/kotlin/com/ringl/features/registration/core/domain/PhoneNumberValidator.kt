package com.ringl.features.registration.core.domain

import com.ringl.features.registration.core.util.PhoneNumberUtils

internal interface PhoneNumberValidator {

    fun validatePhoneNumber(countryCode: String, phoneNumber: String, regionCode: String): Boolean

}

internal class CommonPhoneNumberValidator(
    private val phoneNumberUtils: PhoneNumberUtils
) : PhoneNumberValidator {

    override fun validatePhoneNumber(countryCode: String, phoneNumber: String, regionCode: String): Boolean {
        return phoneNumberUtils.isValidPhoneNumber(countryCode, phoneNumber, regionCode)
    }

}
