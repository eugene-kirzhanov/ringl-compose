package com.ringl.common.core.resources

import com.ringl.common.core.resources.strings.EnStrings
import com.ringl.common.core.resources.strings.IStrings

private val dictionaries = mapOf(
    "en" to EnStrings
)

fun strings(languageCode: String): IStrings {
    return dictionaries[languageCode.lowercase()] ?: EnStrings
}
