package com.ringl.features.registration.core.domain

internal interface RegistrationFormValidator {

    fun validate(countryCode: String, phoneNumber: String, company: String, regionCode: String): Boolean

}

internal class CommonRegistrationFormValidator(
    private val phoneNumberValidator: PhoneNumberValidator,
    private val companyValidator: CompanyValidator
) : RegistrationFormValidator {

    override fun validate(countryCode: String, phoneNumber: String, company: String, regionCode: String): Boolean {
        return phoneNumberValidator.validatePhoneNumber(countryCode, phoneNumber, regionCode)
            && companyValidator.validateCompanyName(company)
    }

}