package com.ringl.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ringl.common.resources.Strings
import com.ringl.common.resources.iconArrowDropDown
import com.ringl.common.resources.imageLogo
import com.ringl.common.theme.robotoFontFamily

@Composable
fun App() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        RegistrationHeader()
        Spacer(Modifier.height(32.dp))
        RegistrationForm()
    }
}

@Composable
private fun RegistrationForm() {
    val countryCode by rememberSaveable { mutableStateOf("+375") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var domain by rememberSaveable { mutableStateOf("") }
    val focusRequester = FocusRequester()
    val inputShape = MaterialTheme.shapes.small.copy(topStart = CornerSize(8.dp), topEnd = CornerSize(8.dp), bottomStart = ZeroCornerSize, bottomEnd = ZeroCornerSize)
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
                    .clickable {
                        // todo показать выбор страны
                    },
                trailingIcon = { iconArrowDropDown() },
                shape = inputShape
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text(Strings.Registration.phoneNumberHint) },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester),
                shape = inputShape,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                )
            )
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = domain,
            onValueChange = { domain = it },
            label = { Text(Strings.Registration.companyHint) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = inputShape,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Done
            )
        )
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                // todo запросить код
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(Strings.Registration.requestCode.uppercase())
        }
        Spacer(Modifier.height(32.dp))
        Text(
            text = buildAnnotatedString {
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

@Composable
fun RegistrationHeader() {
    Spacer(Modifier.height(40.dp))
    Image(
        painter = imageLogo(),
        contentDescription = null,
        modifier = Modifier.size(80.dp)
    )
    Spacer(Modifier.height(24.dp))
    Text(
        text = Strings.Registration.title,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 41.sp,
        letterSpacing = 0.41.sp,
        color = Color.Black
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = Strings.Registration.subtitle,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        letterSpacing = (-0.24).sp,
        color = Color.Black
    )
}
