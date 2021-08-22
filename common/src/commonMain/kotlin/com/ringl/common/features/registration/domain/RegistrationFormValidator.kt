package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale

internal interface RegistrationFormValidator {

    fun validate(countryCode: String, phoneNumber: String, company: String, locale: Locale): Boolean

}

internal class CommonRegistrationFormValidator(
    private val phoneNumberValidator: PhoneNumberValidator,
    private val companyValidator: CompanyValidator
) : RegistrationFormValidator {

    override fun validate(countryCode: String, phoneNumber: String, company: String, locale: Locale): Boolean {
        return phoneNumberValidator.validatePhoneNumber(countryCode, phoneNumber, locale)
            && companyValidator.validateCompanyName(company)
    }

}