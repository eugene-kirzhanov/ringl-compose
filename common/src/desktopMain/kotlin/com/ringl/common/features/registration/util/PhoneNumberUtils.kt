package com.ringl.common.features.registration.util

internal actual fun getPhoneNumberUtils(region: String): PhoneNumberUtils = GooglePhoneNumberUtils(region)