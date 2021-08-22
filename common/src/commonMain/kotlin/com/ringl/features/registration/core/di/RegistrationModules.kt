package com.ringl.features.registration.core.di

import com.ringl.features.registration.core.domain.CommonCompanyValidator
import com.ringl.features.registration.core.domain.CommonPhoneNumberValidator
import com.ringl.features.registration.core.domain.CommonRegistrationFormValidator
import com.ringl.features.registration.core.domain.CompanyValidator
import com.ringl.features.registration.core.domain.PhoneNumberValidator
import com.ringl.features.registration.core.domain.RegistrationFormValidator
import com.ringl.features.registration.core.domain.RegistrationInteractor
import org.koin.core.module.Module
import org.koin.dsl.module

internal val registrationModules = listOf(
    platformRegistrationModule(),
    registrationModule()
)

internal expect fun platformRegistrationModule(): Module

private fun registrationModule() = module {
    factory<PhoneNumberValidator> { CommonPhoneNumberValidator(get()) }
    factory<CompanyValidator> { CommonCompanyValidator() }
    factory<RegistrationFormValidator> { CommonRegistrationFormValidator(get(), get()) }

    single { RegistrationInteractor(get(), get(), get()) }
}