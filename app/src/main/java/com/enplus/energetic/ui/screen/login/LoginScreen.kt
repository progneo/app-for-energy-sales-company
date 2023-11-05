package com.enplus.energetic.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.MainButton
import com.enplus.energetic.ui.components.base.TextField
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Visibility
import com.enplus.energetic.ui.icon.VisibilityOff
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.util.NavDestinations
import com.enplus.energetic.ui.util.PhoneVisualTransformation

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        onAuthorizeClick = { phoneNumber, password ->
            viewModel.authorize(phoneNumber, password)
        },
        onSignIn = {
            navController.navigate(NavDestinations.ONE_TIME_PIN_SCREEN) {
                launchSingleTop = true
                popUpTo(0)
            }
        },
        uiState = uiState,
    )
}

@Composable
fun LoginScreen(
    onAuthorizeClick: (String, String) -> Unit,
    onSignIn: () -> Unit,
    uiState: LoginUiState,
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    if (uiState == LoginUiState.SignIn) {
        onSignIn()
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, end = 16.dp, bottom = 16.dp, start = 16.dp)
            .imePadding(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
                .consumeWindowInsets(scaffoldPadding)
                .systemBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = stringResource(R.string.login_page_title),
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        color = EnColor.TextTitle,
                    )
                    Text(
                        text = stringResource(R.string.login_page_subtitle),
                        fontSize = 17.sp,
                        color = EnColor.TextSubtitle,
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    TextField(
                        modifier = Modifier.focusRequester(focusRequester),
                        value = phoneNumber,
                        onValueChange = { value ->
                            if (value.isDigitsOnly() && value.length <= 10) {
                                phoneNumber = value
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next,
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(
                                FocusDirection.Down,
                            )
                        }),
                        visualTransformation = PhoneVisualTransformation("+7 000 000-00-00", '0'),
                        placeholder = stringResource(R.string.phone_number_hint),
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = stringResource(R.string.password_hint),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        keyboardActions = KeyboardActions(onDone = {
                            onAuthorizeClick(phoneNumber, password)
                        }),
                        visualTransformation = if (isPasswordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        tailingIcon = {
                            if (password.isNotEmpty()) {
                                val image = if (isPasswordVisible) {
                                    EnIcons.Visibility
                                } else {
                                    EnIcons.VisibilityOff
                                }

                                val description =
                                    if (isPasswordVisible) {
                                        stringResource(R.string.hide_password_desc)
                                    } else {
                                        stringResource(R.string.show_password_desc)
                                    }

                                IconButton(
                                    modifier = Modifier.requiredSize(48.dp),
                                    onClick = { isPasswordVisible = !isPasswordVisible },
                                ) {
                                    Icon(imageVector = image, description, tint = EnColor.Orange)
                                }
                            }
                        },
                    )
                    if (uiState == LoginUiState.Error) {
                        Text(
                            text = stringResource(R.string.wrong_login_credentials),
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = EnColor.Red,
                            ),
                        )
                    }
                }
            }
            MainButton(
                text = stringResource(R.string.login),
                onClick = { onAuthorizeClick(phoneNumber, password) },
                isEnabled = phoneNumber.length == 10 && password.isNotEmpty(),
                isLoading = uiState == LoginUiState.InProgress,
            )
        }
    }
}

@Preview("Login screen", showBackground = true, device = Devices.PHONE)
@Composable
fun LoginScreenPreview() {
    EnergeticTheme {
        LoginScreen(
            onAuthorizeClick = { _, _ -> },
            onSignIn = {},
            uiState = LoginUiState.SignedOut,
        )
    }
}

@Preview("Login screen with loading", showBackground = true, device = Devices.PHONE)
@Composable
fun LoginScreenWithLoadingPreview() {
    EnergeticTheme {
        LoginScreen(
            onAuthorizeClick = { _, _ -> },
            onSignIn = {},
            uiState = LoginUiState.InProgress,
        )
    }
}

@Preview("Login screen with wrong input", showBackground = true, device = Devices.PHONE)
@Composable
fun LoginScreenWrongInputPreview() {
    EnergeticTheme {
        LoginScreen(
            onAuthorizeClick = { _, _ -> },
            onSignIn = {},
            uiState = LoginUiState.Error,
        )
    }
}
