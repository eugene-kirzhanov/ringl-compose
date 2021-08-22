package com.ringl.common.features.registration.model

data class RegistrationData(
    val countryCode: String = "",
    val phoneNumber: String = "",
    val company: String = ""
) {

    override fun toString(): String = "$countryCode$phoneNumber@$company"
}