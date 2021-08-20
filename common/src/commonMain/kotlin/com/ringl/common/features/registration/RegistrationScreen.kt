package com.ringl.common.features.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.ringl.common.core.log.logger
import com.ringl.common.features.registration.domain.CommonCompanyValidator
import com.ringl.common.features.registration.domain.CommonPhoneNumberValidator
import com.ringl.common.features.registration.domain.CommonRegistrationFormValidator
import com.ringl.common.features.registration.ui.RegistrationForm
import com.ringl.common.features.registration.ui.RegistrationHeader
import com.ringl.common.features.registration.ui.SelectCountryCodeScreen
import com.ringl.common.features.registration.util.CommonLocaleUtils
import kotlinx.coroutines.launch

// todo провайдить валидаторы через DI
private val phoneNumberValidator = CommonPhoneNumberValidator(Locale.current)
private val companyValidator = CommonCompanyValidator()
private val registrationFormValidator = CommonRegistrationFormValidator(phoneNumberValidator, companyValidator)

@ExperimentalMaterialApi
@Composable
internal fun RegistrationScreen() {
    val coroutineScope = rememberCoroutineScope()

    val localeUtils = CommonLocaleUtils()
    val initialCountryCode = localeUtils.getPhoneNumberCountryCode(Locale.current)

    var countryCode by rememberSaveable { mutableStateOf(initialCountryCode) }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var company by rememberSaveable { mutableStateOf("") }

    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            SelectCountryCodeScreen(
                selectedCountryCode = countryCode,
                onCountryCodeSelected = { selectedCountryCode ->
                    countryCode = selectedCountryCode
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                }
            )
        },
        sheetShape = MaterialTheme.shapes.large,
        sheetElevation = ModalBottomSheetDefaults.Elevation,
        scrimColor = ModalBottomSheetDefaults.scrimColor
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RegistrationHeader()
            Spacer(Modifier.height(32.dp))
            RegistrationForm(
                countryCode = countryCode,
                phoneNumber = phoneNumber,
                company = company,
                isCodeRequestAllowed = registrationFormValidator.validate(countryCode, phoneNumber, company),
                onSelectCountryCode = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                },
                onPhoneNumberChanged = { phoneNumber = it },
                onCompanyChanged = { company = it },
                onCodeRequested = {
                    logger.d { "Request SMS code: $$countryCode$phoneNumber@$company" }
                    // todo запросить код в смс
                }
            )
        }
    }
}
