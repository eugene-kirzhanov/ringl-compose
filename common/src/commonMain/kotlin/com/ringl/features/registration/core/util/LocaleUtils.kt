package com.ringl.features.registration.core.util

internal interface LocaleUtils {

    fun getCurrentRegionCode(): String

    fun getPhoneNumberCountryCode(regionCode: String): String

}
