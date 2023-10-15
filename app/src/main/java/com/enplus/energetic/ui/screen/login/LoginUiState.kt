package com.enplus.energetic.ui.screen.login

sealed class LoginUiState {

    data object SignedOut : LoginUiState()
    data object InProgress : LoginUiState()
    data object Error : LoginUiState()
    data object SignIn : LoginUiState()
}
