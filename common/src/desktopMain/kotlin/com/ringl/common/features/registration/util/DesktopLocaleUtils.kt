package com.ringl.common.features.registration.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import com.google.i18n.phonenumbers.PhoneNumberUtil

internal actual fun getLocaleUtils(): LocaleUtils = DesktopLocaleUtils()

internal class DesktopLocaleUtils : LocaleUtils {

    @Composable
    override fun getPhoneNumberCountryCode(locale: Locale): String {
        val countryCode = PhoneNumberUtil.getInstance()
            .getCountryCodeForRegion(locale.region)
        return "+$countryCode"
    }

}