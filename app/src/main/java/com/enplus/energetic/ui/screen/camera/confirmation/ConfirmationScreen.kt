package com.enplus.energetic.ui.screen.camera.confirmation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.MainButton
import com.enplus.energetic.ui.components.base.TextField
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun ConfirmationScreen(
    navController: NavController,
    accountNumber: String,
    viewModel: ConfirmationViewModel = hiltViewModel(),
) {
    ConfirmationScreen(
        accountNumber = accountNumber,
        onBackClick = { navController.popBackStack() },
    )
}

@Composable
fun ConfirmationScreen(
    accountNumber: String,
    onBackClick: () -> Unit,
) {
    val number = rememberSaveable { mutableStateOf(accountNumber) }
    Scaffold(
        topBar = {
            TopBarWithReturn(onBackClick = onBackClick)
        },
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier.padding(scaffoldPadding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = stringResource(R.string.confirm_data),
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                color = EnColor.TextTitle,
            )
            TextField(
                value = number.value,
                onValueChange = { value ->
                    number.value = value
                },
                placeholder = stringResource(R.string.enter_account_number_hint),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                MainButton(
                    text = stringResource(R.string.main_page_find_button_text),
                    onClick = { /*TODO*/ },
                )
                MainButton(
                    text = stringResource(R.string.scan_again),
                    onClick = onBackClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = EnColor.OrangeContainer,
                        contentColor = EnColor.Orange,
                    ),
                )
            }
        }
    }
}

@Preview(name = "Confirmation Screen")
@Composable
fun ConfirmationScreenPreview() {
    EnergeticTheme {
        ConfirmationScreen(accountNumber = "272819", onBackClick = {})
    }
}
