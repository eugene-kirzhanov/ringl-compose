package com.ringl.common.features.registration.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ringl.common.features.registration.util.CommonPhoneNumberFormatter
import com.ringl.common.resources.Strings
import com.ringl.common.resources.iconArrowDropDown
import com.ringl.common.theme.inputShape
import com.ringl.common.theme.robotoFontFamily

@Composable
internal fun RegistrationForm(
    countryCode: String,
    phoneNumber: String,
    company: String,
    isCodeRequestAllowed: Boolean,
    onSelectCountryCode: () -> Unit,
    onPhoneNumberChanged: (phoneNumber: String) -> Unit,
    onCompanyChanged: (company: String) -> Unit,
    onCodeRequested: () -> Unit
) {
    val phoneNumberFormatter = CommonPhoneNumberFormatter(Locale.current)
    val focusRequester = FocusRequester()
    Column(
        modifier = Modifier.widthIn(max = 400.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = countryCode,
                onValueChange = { },
                singleLine = true,
                label = { Text(Strings.Registration.countryCodeHint) },
                enabled = false,
                modifier = Modifier
                    .width(120.dp)
                    .clickable(onClick = onSelectCountryCode),
                trailingIcon = { iconArrowDropDown() },
                shape = inputShape()
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = phoneNumber,
                onValueChange = { input ->
                    val filtered = input.filter {
                        it.isDigit() || it == ' ' || it == '-' || it == '(' || it == ')'
                    }
                    onPhoneNumberChanged(filtered)
                },
                label = { Text(Strings.Registration.phoneNumberHint) },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        if (!it.hasFocus) {
                            val formatted = phoneNumberFormatter.formatPhoneNumber(countryCode, phoneNumber)
                            onPhoneNumberChanged(formatted)
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
            value = company,
            onValueChange = onCompanyChanged,
            label = { Text(Strings.Registration.companyHint) },
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
            enabled = isCodeRequestAllowed
        ) {
            Text(Strings.Registration.requestCode.uppercase())
        }
        Spacer(Modifier.height(32.dp))
        Text(
            text = buildAnnotatedString {
                // todo сделать ссылки кликабельными
                append(Strings.Registration.agreementLinks)
            },
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
    }

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}
