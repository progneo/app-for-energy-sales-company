package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.oneTimePin.InputOneTimePin
import com.enplus.energetic.ui.components.oneTimePin.NumberPad
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.theme.Orange
import com.enplus.energetic.util.NavDestinations

@Composable
fun OneTimePinScreen(
    navController: NavController,
    viewModel: OneTimePinViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    OneTimePinScreen(
        uiState = uiState,
        onEqualPin = { viewModel.equalPin(it) },
        onCreatePin = { viewModel.createPin(it) },
        onSavePin = { viewModel.savePin(it) },
        onCompleted = { navController.navigate(NavDestinations.MAIN_SCREEN) { popUpTo(0) } },
    )
}

@Composable
fun OneTimePinScreen(
    uiState: OneTimePinUiState,
    onEqualPin: (String) -> Unit,
    onCreatePin: (String) -> Unit,
    onSavePin: (String) -> Unit,
    onCompleted: () -> Unit,
) {
    Scaffold(
        content = { paddingValues ->
            when (uiState) {
                OneTimePinUiState.Completed -> {
                    LaunchedEffect(Unit) {
                        onCompleted()
                    }
                }
                OneTimePinUiState.InProcessing -> {
                    /*TODO*/
                }
                OneTimePinUiState.InputtingPin -> {
                    OneTimePinContent(
                        paddingValues = paddingValues,
                        title = stringResource(id = R.string.input_pin),
                        onLogoutButtonClick = { /*TODO*/ },
                        onInputComplete = { onEqualPin(it) },
                    )
                }
                OneTimePinUiState.CreatePin -> {
                    OneTimePinContent(
                        paddingValues = paddingValues,
                        title = stringResource(id = R.string.create_pin),
                        onLogoutButtonClick = { /*TODO*/ },
                        onInputComplete = { onCreatePin(it) },
                    )
                }
                OneTimePinUiState.RepeatPin -> {
                    OneTimePinContent(
                        paddingValues = paddingValues,
                        title = stringResource(id = R.string.repeat_pin),
                        onLogoutButtonClick = { /*TODO*/ },
                        onInputComplete = { onSavePin(it) },
                    )
                }
                is OneTimePinUiState.Error -> {
                    OneTimePinContent(
                        paddingValues = paddingValues,
                        title = when (uiState.previousState) {
                            OneTimePinUiState.InputtingPin -> stringResource(id = R.string.input_pin)
                            OneTimePinUiState.RepeatPin -> stringResource(id = R.string.repeat_pin)
                            else -> ""
                        },
                        isError = true,
                        onLogoutButtonClick = { /*TODO*/ },
                        onInputComplete = { },
                    )
                }
            }
        },
    )
}

@Composable
fun OneTimePinContent(
    paddingValues: PaddingValues,
    pinLength: Int = 4,
    title: String,
    isError: Boolean = false,
    isShowLogoutButton: Boolean = true,
    onLogoutButtonClick: () -> Unit,
    onInputComplete: (String) -> Unit,
) {
    var inputtedPin by remember { mutableStateOf("") }

    LaunchedEffect(inputtedPin) {
        if (inputtedPin.length == pinLength) {
            onInputComplete(inputtedPin)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding() + 161.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(161.dp),
    ) {
        InputOneTimePin(
            title = title,
            dpActiveColor = if (isError) Color.Red else Orange,
            pinInputtedLength = if (isError) pinLength else inputtedPin.length,
        )

        NumberPad(
            isShowBackspaceButton = if (isError) true else inputtedPin.isNotEmpty(),
            isShowLogoutButton = isShowLogoutButton,
            onNumberButtonClick = {
                if (!isError) {
                    inputtedPin += it.toString()
                }
            },
            onBackspaceButtonClick = {
                if (!isError) {
                    inputtedPin = inputtedPin.dropLast(1)
                }
            },
            onLogoutButtonClick = { onLogoutButtonClick() },
        )
    }
}

@Preview(name = "Input PIN", group = "Input PIN", showBackground = true, showSystemUi = true)
@Composable
fun InputPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            uiState = OneTimePinUiState.InputtingPin,
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
        )
    }
}

@Preview(name = "Error input PIN", group = "Input PIN", showBackground = true)
@Composable
fun ErrorInputPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            uiState = OneTimePinUiState.Error(previousState = OneTimePinUiState.InputtingPin),
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
        )
    }
}

@Preview(name = "Create PIN", group = "Setup PIN", showBackground = true)
@Composable
fun CreatePinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            uiState = OneTimePinUiState.CreatePin,
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
        )
    }
}

@Preview(name = "Repeat PIN", group = "Setup PIN", showBackground = true)
@Composable
fun RepeatPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            uiState = OneTimePinUiState.RepeatPin,
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
        )
    }
}

@Preview(name = "Error repeat PIN", group = "Setup PIN", showBackground = true)
@Composable
fun ErrorRepeatPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            uiState = OneTimePinUiState.Error(previousState = OneTimePinUiState.RepeatPin),
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
        )
    }
}
