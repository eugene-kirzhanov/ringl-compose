package com.ringl.features.registration.core.util

internal interface PhoneNumberUtils {

    fun formatNumber(countryCode: String, phoneNumber: String, regionCode: String): String

    fun isValidPhoneNumber(countryCode: String, phoneNumber: String, regionCode: String): Boolean

}
