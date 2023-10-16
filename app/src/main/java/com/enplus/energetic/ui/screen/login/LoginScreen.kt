package com.enplus.energetic.ui.screen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.util.NavDestinations

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    LoginScreen(
        onAuthorizeClick = {
            viewModel.authorize()
            navController.navigate(NavDestinations.ONE_TIME_PIN_SCREEN) { popUpTo(0) }
        },
    )
}

@Composable
fun LoginScreen(
    onAuthorizeClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = onAuthorizeClick,
            content = { Text("Authorize") },
        )
    }
}

@Preview(showBackground = true, name = "Login screen")
@Composable
fun LoginScreenPreview() {
    EnergeticTheme {
        LoginScreen(
            onAuthorizeClick = {},
        )
    }
}
