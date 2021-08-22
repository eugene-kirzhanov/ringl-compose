package com.ringl.common.features.registration.di

import com.ringl.common.features.registration.util.AndroidLocaleUtils
import com.ringl.common.features.registration.util.GooglePhoneNumberUtils
import com.ringl.common.features.registration.util.LocaleUtils
import com.ringl.common.features.registration.util.PhoneNumberUtils
import org.koin.dsl.module

internal actual fun platformRegistrationModule() = module {
    factory<LocaleUtils> { AndroidLocaleUtils(get()) }
    factory<PhoneNumberUtils> { GooglePhoneNumberUtils() }
}