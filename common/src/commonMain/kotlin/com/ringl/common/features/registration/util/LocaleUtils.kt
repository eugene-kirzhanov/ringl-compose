package com.ringl.common.features.registration.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale

internal expect fun getLocaleUtils(): LocaleUtils

internal interface LocaleUtils {

    @Composable
    fun getPhoneNumberCountryCode(locale: Locale): String

}

internal class CommonLocaleUtils : LocaleUtils {

    private val platformLocaleUtils = getLocaleUtils()

    @Composable
    override fun getPhoneNumberCountryCode(locale: Locale): String {
        return platformLocaleUtils.getPhoneNumberCountryCode(locale)
    }

}