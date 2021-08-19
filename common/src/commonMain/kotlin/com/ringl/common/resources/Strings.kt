package com.ringl.common.resources

import androidx.compose.ui.text.intl.Locale
import com.ringl.common.resources.strings.EnStrings
import com.ringl.common.resources.strings.IStrings

private val dictionaries = mapOf(
    "en" to EnStrings
)

fun strings(locale: Locale = Locale.current): IStrings {
    return dictionaries[locale.language.lowercase()] ?: EnStrings
}
