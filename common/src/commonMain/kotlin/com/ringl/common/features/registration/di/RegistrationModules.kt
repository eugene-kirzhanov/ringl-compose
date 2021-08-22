package com.ringl.common.features.registration.di

import com.ringl.common.features.registration.domain.CommonCompanyValidator
import com.ringl.common.features.registration.domain.CommonPhoneNumberValidator
import com.ringl.common.features.registration.domain.CommonRegistrationFormValidator
import com.ringl.common.features.registration.domain.CompanyValidator
import com.ringl.common.features.registration.domain.PhoneNumberValidator
import com.ringl.common.features.registration.domain.RegistrationFormValidator
import com.ringl.common.features.registration.domain.RegistrationInteractor
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