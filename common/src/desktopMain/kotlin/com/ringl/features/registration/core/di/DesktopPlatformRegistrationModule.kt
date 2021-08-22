package com.ringl.features.registration.core.di

import com.ringl.features.registration.core.util.LocaleUtils
import com.ringl.features.registration.core.util.PhoneNumberUtils
import com.ringl.features.registration.util.DesktopLocaleUtils
import com.ringl.features.registration.util.GooglePhoneNumberUtils
import org.koin.dsl.module

internal actual fun platformRegistrationModule() = module {
    factory<LocaleUtils> { DesktopLocaleUtils() }
    factory<PhoneNumberUtils> { GooglePhoneNumberUtils() }
}