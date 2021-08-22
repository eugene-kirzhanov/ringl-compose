package com.ringl.features.registration.core.di

import com.ringl.features.registration.core.util.AndroidLocaleUtils
import com.ringl.features.registration.core.util.GooglePhoneNumberUtils
import com.ringl.features.registration.core.util.LocaleUtils
import com.ringl.features.registration.core.util.PhoneNumberUtils
import org.koin.dsl.module

internal actual fun platformRegistrationModule() = module {
    factory<LocaleUtils> { AndroidLocaleUtils(get()) }
    factory<PhoneNumberUtils> { GooglePhoneNumberUtils() }
}