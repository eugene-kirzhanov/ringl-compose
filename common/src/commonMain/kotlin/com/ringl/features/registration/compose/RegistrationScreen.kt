package com.ringl.features.registration.compose

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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ringl.common.compose.util.getKoin
import com.ringl.common.compose.util.rememberComposeViewModel
import com.ringl.features.registration.core.di.registrationModules
import com.ringl.features.registration.core.domain.RegistrationViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
internal fun RegistrationScreen() {
    val koin = getKoin()
    koin.loadModules(registrationModules)
    DisposableEffect(Unit) {
        onDispose {
            koin.unloadModules(registrationModules)
        }
    }

    val coroutineScope = rememberCoroutineScope()

    val viewModel = rememberComposeViewModel {
        RegistrationViewModel(koin.get(), koin.get())
    }

    val registrationData by viewModel.registrationData.collectAsState()
    val isDataValid by viewModel.isDataValid.collectAsState(false)

    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            SelectCountryCodeScreen(
                selectedCountryCode = registrationData.countryCode,
                onCountryCodeSelected = { selectedCountryCode ->
                    viewModel.onCountryCodeSelected(selectedCountryCode)
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
                registrationData = registrationData,
                isCodeRequestAllowed = isDataValid,
                onSelectCountryCode = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                },
                onPhoneNumberChanged = viewModel::onPhoneNumberChanged,
                onCompanyChanged = viewModel::onCompanyChanged,
                onCodeRequested = viewModel::requestSmsCode
            )
        }
    }
}
