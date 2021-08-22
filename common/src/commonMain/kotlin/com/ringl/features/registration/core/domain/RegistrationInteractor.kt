package com.ringl.features.registration.core.domain

import co.touchlab.kermit.Kermit
import com.ringl.features.registration.core.model.RegistrationData
import com.ringl.features.registration.core.util.LocaleUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class RegistrationInteractor(
    private val localeUtils: LocaleUtils,
    private val registrationFormValidator: RegistrationFormValidator,
    private val logger: Kermit
) {

    fun getInitialCountryCode(): String {
        return localeUtils.getPhoneNumberCountryCode(localeUtils.getCurrentRegionCode())
    }

    fun isRegistrationDataValid(data: RegistrationData): Boolean {
        return registrationFormValidator.validate(data.countryCode, data.phoneNumber, data.company, localeUtils.getCurrentRegionCode())
    }

    suspend fun requestSmsCode(data: RegistrationData) {
        withContext(Dispatchers.Default) {
            logger.d { "Request SMS code for: $data" }
        }
    }

}