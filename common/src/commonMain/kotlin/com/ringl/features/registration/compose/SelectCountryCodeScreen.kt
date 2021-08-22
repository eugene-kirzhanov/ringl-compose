package com.ringl.features.registration.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ringl.common.core.resources.countries
import kotlinx.coroutines.launch

@Composable
internal fun SelectCountryCodeScreen(
    focusRequester: FocusRequester,
    onCountryCodeSelected: (selectedCountryCode: String) -> Unit,
    onClosed: () -> Unit
) {
    var query by remember { mutableStateOf("") }

    val trimmedQuery = query.trim()
    val filteredCountries = countries.filter {
        it.name.contains(trimmedQuery, ignoreCase = true)
            || it.code.contains(trimmedQuery, ignoreCase = true)
            || it.dialCode.contains(trimmedQuery, ignoreCase = true)
    }

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clickable(onClick = onClosed)
                    .padding(12.dp)
            )
            TextField(
                value = query,
                onValueChange = {
                    query = it
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    placeholderColor = Color.LightGray
                ),
                placeholder = { Text("Enter country name...") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .focusRequester(focusRequester)
            )
        }

        Divider(thickness = 1.dp)

        LazyColumn(state = listState) {
            items(filteredCountries) { country ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            coroutineScope.launch {
                                query = ""
                                listState.scrollToItem(index = 0, scrollOffset = 0)
                                onCountryCodeSelected(country.dialCode)
                            }
                        }
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = country.name,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = country.dialCode,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
