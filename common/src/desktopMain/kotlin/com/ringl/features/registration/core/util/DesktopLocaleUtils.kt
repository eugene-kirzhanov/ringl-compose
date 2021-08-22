package com.ringl.features.registration.core.util

import com.google.i18n.phonenumbers.PhoneNumberUtil
import java.util.Locale

internal class DesktopLocaleUtils : LocaleUtils {

    override fun getCurrentRegionCode(): String {
        return Locale.getDefault().country
    }

    override fun getPhoneNumberCountryCode(regionCode: String): String {
        val countryCode = PhoneNumberUtil.getInstance()
            .getCountryCodeForRegion(regionCode)
        return "+$countryCode"
    }

}