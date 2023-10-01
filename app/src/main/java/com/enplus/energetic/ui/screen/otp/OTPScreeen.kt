package com.enplus.energetic.ui.screen.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enplus.energetic.ui.components.otp.InputOTP
import com.enplus.energetic.ui.components.otp.NumberPad
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun OTPScreen(
    viewModel: OTPViewModel = hiltViewModel(),
) {
    val isUserAuthorized by viewModel.isUserAuthorized.observeAsState(initial = false)
    val pinLength by viewModel.pinLength.observeAsState(initial = 4)
    val inputtedPinLength by viewModel.inputtedPinLength.observeAsState(initial = 4)


    OTPScreen(
        isUserAuthorized = isUserAuthorized,
        pinLength = pinLength,
        inputtedPinLength = inputtedPinLength,
        onNumberButtonClick = { viewModel.onNumberButtonClick(it) },
        onBackspaceButtonClick = { viewModel.onBackspaceButtonClick() },
    )
}

@Composable
fun OTPScreen(
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

        InputOTP(
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
fun OTPScreenPreview() {
    EnergeticTheme {
        OTPScreen(
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
fun OTPScreenInputPreview() {
    EnergeticTheme {
        OTPScreen(
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
fun OTPScreenWithViewModelPreview() {
    EnergeticTheme {
        OTPScreen(viewModel = hiltViewModel())
    }
}
