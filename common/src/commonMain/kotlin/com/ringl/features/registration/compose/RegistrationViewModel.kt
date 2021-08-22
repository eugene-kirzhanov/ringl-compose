package com.ringl.features.registration.compose

import co.touchlab.kermit.Kermit
import com.ringl.common.compose.util.ComposeViewModel
import com.ringl.features.registration.core.domain.RegistrationInteractor
import com.ringl.features.registration.core.model.RegistrationData
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

internal class RegistrationViewModel(
    private val interactor: RegistrationInteractor,
    private val log: Kermit
) : ComposeViewModel() {

    private val _registrationData = MutableStateFlow(RegistrationData(countryCode = interactor.getInitialCountryCode()))
    val registrationData = _registrationData.asStateFlow()

    val isDataValid = _registrationData
        .map(interactor::isRegistrationDataValid)

    fun onCountryCodeSelected(countryCode: String) {
        _registrationData.value = _registrationData.value.copy(countryCode = countryCode)
    }

    fun onPhoneNumberChanged(phoneNumber: String) {
        _registrationData.value = _registrationData.value.copy(phoneNumber = phoneNumber)
    }

    fun onCompanyChanged(company: String) {
        _registrationData.value = _registrationData.value.copy(company = company)
    }

    fun requestSmsCode() {
        coroutineScope.launch {
            try {
                interactor.requestSmsCode(_registrationData.value)
            } catch (e: Exception) {
                if (e !is CancellationException) {
                    log.v { "Error requesting SMS code: ${e.message}" }
                }
            }
        }
    }

}