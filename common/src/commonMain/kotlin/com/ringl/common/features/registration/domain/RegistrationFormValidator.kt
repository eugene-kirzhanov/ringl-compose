package com.ringl.common.features.registration.domain

internal interface RegistrationFormValidator {
    fun validate(countryCode: String, phoneNumber: String, company: String): Boolean
}

internal class CommonRegistrationFormValidator(
    private val phoneNumberValidator: PhoneNumberValidator,
    private val companyValidator: CompanyValidator
) : RegistrationFormValidator {

    override fun validate(countryCode: String, phoneNumber: String, company: String): Boolean {
        return phoneNumberValidator.validatePhoneNumber(countryCode, phoneNumber)
            && companyValidator.validateCompanyName(company)
    }

}