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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enplus.energetic.ui.components.oneTimePin.InputOneTimePin
import com.enplus.energetic.ui.components.oneTimePin.NumberPad
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun OneTimePinScreen(
    viewModel: OneTimePinViewModel = hiltViewModel(),
) {
    val isUserAuthorized = viewModel.isUserAuthorized

    val pinLength by remember { mutableIntStateOf(4) }
    var inputtedPin by remember { mutableStateOf("") }

    LaunchedEffect(pinLength == inputtedPin.length) {
        viewModel.completePinInput(inputtedPin)
    }

    OneTimePinScreen(
        isUserAuthorized = isUserAuthorized,
        pinLength = pinLength,
        inputtedPinLength = inputtedPin.length,
        onNumberButtonClick = {
            inputtedPin += it.toString()
        },
        onBackspaceButtonClick = {
            inputtedPin = inputtedPin.dropLast(1)
        },
    )
}

@Composable
fun OneTimePinScreen(
    isUserAuthorized: Boolean,
    pinLength: Int,
    inputtedPinLength: Int,
    onNumberButtonClick: (Int) -> Unit,
    onBackspaceButtonClick: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = "Something text",
            style = MaterialTheme.typography.headlineLarge,
        )

        InputOneTimePin(
            modifier = Modifier
                .padding(horizontal = 80.dp),
            pinLength = pinLength,
            pinInputtedLength = inputtedPinLength,
        )

        NumberPad(
            modifier = Modifier
                .padding(horizontal = 70.dp),
            isShowBackspaceButton = inputtedPinLength > 0,
            isShowLogoutButton = isUserAuthorized,
            onNumberButtonClick = { onNumberButtonClick(it) },
            onBackspaceButtonClick = { onBackspaceButtonClick() },
            onLogoutButtonClick = { /*TODO*/ },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            isUserAuthorized = true,
            pinLength = 4,
            inputtedPinLength = 0,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OneTimePinScreenInputPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            isUserAuthorized = true,
            pinLength = 4,
            inputtedPinLength = 3,
            onNumberButtonClick = { },
            onBackspaceButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OneTimePinScreenWithViewModelPreview() {
    EnergeticTheme {
        OneTimePinScreen(viewModel = hiltViewModel())
    }
}
