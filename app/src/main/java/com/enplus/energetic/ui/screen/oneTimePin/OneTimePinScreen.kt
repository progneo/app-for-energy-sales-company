package com.enplus.energetic.ui.screen.oneTimePin

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.data.model.PinState
import com.enplus.energetic.ui.components.oneTimePin.InputOneTimePin
import com.enplus.energetic.ui.components.oneTimePin.NumberPad
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.util.NavDestinations

@Composable
fun OneTimePinScreen(
    navController: NavController,
    viewModel: OneTimePinViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val inputtedPin = viewModel.inputtedPin

    OneTimePinScreen(
        inputtedPin = inputtedPin,
        uiState = uiState,
        onInputtingPin = { viewModel.inputtingPin(it) },
        onEqualPin = viewModel::equalPin,
        onCreatePin = viewModel::createPin,
        onSavePin = viewModel::savePin,
        onCompleted = { navController.navigate(NavDestinations.MAIN_SCREEN) { popUpTo(0) } },
        onLogoutButtonClick = {
            navController.navigate(NavDestinations.LOGIN_SCREEN) { popUpTo(0) }
            //TODO the logout method call from view model
        },
    )
}

@SuppressLint("MissingPermission")
@Composable
fun OneTimePinScreen(
    inputtedPin: String,
    uiState: OneTimePinUiState,
    onInputtingPin: (String) -> Unit,
    onEqualPin: () -> Unit,
    onCreatePin: () -> Unit,
    onSavePin: () -> Unit,
    onCompleted: () -> Unit,
    onLogoutButtonClick: () -> Unit,
) {
    LaunchedEffect(inputtedPin) {
        if (inputtedPin.length == 4) {
            when (uiState) {
                OneTimePinUiState.InputtingPin -> onEqualPin()
                OneTimePinUiState.CreatePin -> onCreatePin()
                OneTimePinUiState.RepeatPin -> onSavePin()
                else -> Unit
            }
        }
    }

    @Suppress("DEPRECATION in Java")
    val vibrator = LocalContext.current.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    val errorVibrationEffect: VibrationEffect =
        VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
    val successVibrationEffect: VibrationEffect? =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK)
        } else {
            /* TODO("VERSION.SDK_INT < Q") */
            null
        }

    Scaffold(
        containerColor = EnColor.Background,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding(),
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var titleResId by remember { mutableStateOf<Int?>(null) }

                var state by remember { mutableStateOf(PinState.INPUT_PROCESS) }

                LaunchedEffect(uiState) {
                    when (uiState) {
                        OneTimePinUiState.InputtingPin -> {
                            titleResId = R.string.input_pin
                            state = PinState.INPUT_PROCESS
                        }
                        OneTimePinUiState.CreatePin -> {
                            titleResId = R.string.create_pin
                            state = PinState.INPUT_PROCESS
                        }
                        OneTimePinUiState.RepeatPin -> {
                            titleResId = R.string.repeat_pin
                            state = PinState.INPUT_PROCESS
                        }
                        OneTimePinUiState.InProcessing -> { /*TODO processing state*/ }
                        is OneTimePinUiState.Success -> {
                            titleResId = when (uiState.previousState) {
                                OneTimePinUiState.InputtingPin -> R.string.input_pin
                                OneTimePinUiState.RepeatPin -> R.string.repeat_pin
                                else -> 0
                            }
                            state = PinState.SUCCESS

                            successVibrationEffect?.let {
                                vibrator.cancel()
                                vibrator.vibrate(successVibrationEffect)
                            }
                        }
                        is OneTimePinUiState.Error -> {
                            titleResId = when (uiState.previousState) {
                                OneTimePinUiState.InputtingPin -> R.string.input_pin
                                OneTimePinUiState.RepeatPin -> R.string.repeat_pin
                                else -> 0
                            }
                            state = PinState.ERROR

                            vibrator.cancel()
                            vibrator.vibrate(errorVibrationEffect)
                        }
                        OneTimePinUiState.Completed -> { onCompleted() }
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight(Alignment.CenterVertically),
                ) {
                    InputOneTimePin(
                        modifier = Modifier.widthIn(max = 280.dp),
                        title = stringResource(id = titleResId ?: R.string.input_pin),
                        pinState = state,
                        pinInputtedLength = inputtedPin.length,
                    )
                }

                Column(
                    modifier = Modifier
                        .wrapContentHeight(Alignment.Bottom),
                ) {
                    NumberPad(
                        enabled = when (uiState) {
                            OneTimePinUiState.InputtingPin,
                            OneTimePinUiState.CreatePin,
                            OneTimePinUiState.RepeatPin -> true
                            else -> false
                        },
                        isShowBackspaceButton = inputtedPin.isNotEmpty(),
                        isShowLogoutButton = true,
                        onNumberButtonClick = { onInputtingPin(inputtedPin + it.toString()) },
                        onBackspaceButtonClick = { onInputtingPin(inputtedPin.dropLast(1)) },
                        onLogoutButtonClick = { onLogoutButtonClick() },
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        },
    )
}

@Preview(name = "Input PIN", group = "Input PIN", showBackground = true, showSystemUi = true)
@Composable
fun InputPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "   ",
            uiState = OneTimePinUiState.InputtingPin,
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Success input PIN", group = "Input PIN", showBackground = true)
@Composable
fun SuccessInputPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.Success(previousState = OneTimePinUiState.InputtingPin),
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Error input PIN", group = "Input PIN", showBackground = true)
@Composable
fun ErrorInputPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.Error(previousState = OneTimePinUiState.InputtingPin),
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Create PIN", group = "Setup PIN", showBackground = true)
@Composable
fun CreatePinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.CreatePin,
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Repeat PIN", group = "Setup PIN", showBackground = true)
@Composable
fun RepeatPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.RepeatPin,
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Success repeat PIN", group = "Setup PIN", showBackground = true)
@Composable
fun SuccessRepeatPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.Success(previousState = OneTimePinUiState.RepeatPin),
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}

@Preview(name = "Error repeat PIN", group = "Setup PIN", showBackground = true)
@Composable
fun ErrorRepeatPinOneTimePinScreenPreview() {
    EnergeticTheme {
        OneTimePinScreen(
            inputtedPin = "",
            uiState = OneTimePinUiState.Error(previousState = OneTimePinUiState.RepeatPin),
            onInputtingPin = { },
            onEqualPin = { },
            onCreatePin = { },
            onSavePin = { },
            onCompleted = { },
            onLogoutButtonClick = { },
        )
    }
}
