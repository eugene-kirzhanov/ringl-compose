package com.ringl.common.features.registration.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale

internal interface LocaleUtils {

    @Composable
    fun getPhoneNumberCountryCode(locale: Locale): String

}

internal class CommonLocaleUtils : LocaleUtils by getLocaleUtils()

internal expect fun getLocaleUtils(): LocaleUtils