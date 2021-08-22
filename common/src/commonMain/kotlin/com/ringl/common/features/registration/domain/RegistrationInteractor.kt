package com.ringl.common.features.registration.domain

import androidx.compose.ui.text.intl.Locale
import co.touchlab.kermit.Kermit
import com.ringl.common.features.registration.model.RegistrationData
import com.ringl.common.features.registration.util.LocaleUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class RegistrationInteractor(
    private val localeUtils: LocaleUtils,
    private val registrationFormValidator: RegistrationFormValidator,
    private val logger: Kermit
) {

    fun getInitialCountryCode(): String {
        return localeUtils.getPhoneNumberCountryCode(Locale.current)
    }

    fun validateRegistrationData(data: RegistrationData): Boolean {
        return registrationFormValidator.validate(data.countryCode, data.phoneNumber, data.company, Locale.current)
    }

    suspend fun requestSmsCode(data: RegistrationData) {
        withContext(Dispatchers.Default) {
            logger.d { "Request SMS code for: $data" }
        }
    }

}