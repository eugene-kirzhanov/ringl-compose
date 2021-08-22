package com.ringl.common.features.registration.util

import androidx.compose.ui.text.intl.Locale

internal interface LocaleUtils {

    fun getPhoneNumberCountryCode(locale: Locale): String

}
