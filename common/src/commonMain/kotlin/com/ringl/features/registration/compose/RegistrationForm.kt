package com.ringl.features.registration.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ringl.common.compose.resources.strings
import com.ringl.common.compose.theme.buttonShape
import com.ringl.common.compose.theme.inputShape
import com.ringl.common.compose.theme.robotoFontFamily
import com.ringl.common.compose.util.get
import com.ringl.common.core.util.format
import com.ringl.features.registration.core.model.RegistrationData
import com.ringl.features.registration.core.util.PhoneNumberUtils

@ExperimentalComposeUiApi
@Composable
internal fun RegistrationForm(
    registrationData: RegistrationData,
    isCodeRequestAllowed: Boolean,
    onSelectCountryCode: () -> Unit,
    onPhoneNumberChanged: (phoneNumber: String) -> Unit,
    onCompanyChanged: (company: String) -> Unit,
    onCodeRequested: () -> Unit
) {
    val phoneNumberUtils = get<PhoneNumberUtils>()
    val formattedNumber = phoneNumberUtils.formatNumber(registrationData.countryCode, registrationData.phoneNumber, Locale.current.region)

    val focusRequester = FocusRequester()
    Column(
        modifier = Modifier.widthIn(max = 400.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = registrationData.countryCode,
                onValueChange = { },
                singleLine = true,
                label = { Text(strings().registration.countryCodeHint) },
                enabled = false,
                modifier = Modifier
                    .width(126.dp)
                    .clickable(onClick = onSelectCountryCode),
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                },
                shape = inputShape(),
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = registrationData.phoneNumber,
                onValueChange = { input ->
                    val filtered = input.filter {
                        it.isDigit() || it == ' ' || it == '-' || it == '(' || it == ')'
                    }
                    onPhoneNumberChanged(filtered)
                },
                label = { Text(strings().registration.phoneNumberHint) },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        if (!it.hasFocus) {
                            onPhoneNumberChanged(formattedNumber)
                        }
                    },
                shape = inputShape(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = registrationData.company,
            onValueChange = onCompanyChanged,
            label = { Text(strings().registration.companyHint) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = inputShape(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Done
            )
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = onCodeRequested,
            modifier = Modifier.fillMaxWidth(),
            enabled = isCodeRequestAllowed,
            shape = buttonShape()
        ) {
            Text(strings().registration.requestCode.uppercase())
        }
        Spacer(Modifier.height(32.dp))
        AgreementText()
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(registrationData.countryCode) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }
}

@Composable
private fun AgreementText() {
    val agreementText = buildAnnotatedString {
        val privacyPolicyText = strings().registration.agreementSubTextPrivacyPolicy
        val termsText = strings().registration.agreementSubTextTerms
        val text = strings().registration.agreementText.format(privacyPolicyText, termsText)
        append(text)

        val urlSpanStyle = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)

        val privacyPolicyPos = text.indexOf(privacyPolicyText)
        val privacyPolicyUrl = strings().about.privacyPolicyUrl
        addStyle(urlSpanStyle, privacyPolicyPos, privacyPolicyPos + privacyPolicyText.length)
        addStringAnnotation("URL", annotation = privacyPolicyUrl, privacyPolicyPos, privacyPolicyPos + privacyPolicyText.length)

        val termsPos = text.indexOf(termsText)
        val termsUrl = strings().about.termsUrl
        addStyle(urlSpanStyle, termsPos, termsPos + termsText.length)
        addStringAnnotation("URL", annotation = termsUrl, termsPos, termsPos + termsText.length)
    }
    val uriHandler = LocalUriHandler.current
    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    Text(
        text = agreementText,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.DarkGray,
        textAlign = TextAlign.Center,
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures { offsetPosition ->
                layoutResult.value?.let {
                    val position = it.getOffsetForPosition(offsetPosition)
                    agreementText.getStringAnnotations(position, position).firstOrNull()?.let { result ->
                        if (result.tag == "URL") {
                            uriHandler.openUri(result.item)
                        }
                    }
                }
            }
        },
        onTextLayout = { layoutResult.value = it }
    )
}
