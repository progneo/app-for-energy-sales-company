package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.oneTimePin.InputOneTimePin
import com.enplus.energetic.ui.components.oneTimePin.NumberPad
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun OneTimePinScreen(
    viewModel: OneTimePinViewModel = hiltViewModel(),
) {
    val isUserAuthorized = viewModel.isUserAuthorized

    val pinLength by remember { mutableIntStateOf(4) }

    OneTimePinScreen(
        isUserAuthorized = isUserAuthorized,
        pinLength = pinLength,
        onCompletePinInput = {
            viewModel.completePinInput(it)
        },
    )
}

@Composable
fun OneTimePinScreen(
    isUserAuthorized: Boolean,
    pinLength: Int,
    onCompletePinInput: (String) -> Unit,
) {
    var inputtedPin by remember { mutableStateOf("") }

    LaunchedEffect(key1 = pinLength == inputtedPin.length) {
        onCompletePinInput(inputtedPin)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = if (isUserAuthorized) stringResource(R.string.input_pin) else stringResource(R.string.create_pin),
            style = MaterialTheme.typography.headlineLarge,
        )

        InputOneTimePin(
            pinLength = pinLength,
            pinInputtedLength = inputtedPin.length,
        )

        NumberPad(
            isShowBackspaceButton = inputtedPin.isNotEmpty(),
            isShowLogoutButton = isUserAuthorized,
            onNumberButtonClick = { inputtedPin += it.toString() },
            onBackspaceButtonClick = { inputtedPin = inputtedPin.dropLast(1) },
            onLogoutButtonClick = { /*TODO*/ },
        )
    }
}

@Preview(name = "OTP screen", showBackground = true)
@Composable
fun OneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            isUserAuthorized = false,
            pinLength = 4,
            onCompletePinInput = {},
        )
    }
}

@Preview(name = "OTP screen with authorized user", showBackground = true)
@Composable
fun OneTimePinScreenAuthorizedPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            isUserAuthorized = true,
            pinLength = 4,
            onCompletePinInput = {},
        )
    }
}
