package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.PhoneNumberUtil

internal class DesktopLocaleUtils : LocaleUtils {

    override fun getPhoneNumberCountryCode(locale: Locale): String {
        val countryCode = PhoneNumberUtil.getInstance()
            .getCountryCodeForRegion(locale.region)
        return "+$countryCode"
    }

}