package com.enplus.energetic.ui.screen.oneTimePin

sealed class OneTimePinUiState {
    data object Completed: OneTimePinUiState()

    data object InProcessing: OneTimePinUiState()

    data object InputtingPin: OneTimePinUiState()

    data object CreatePin: OneTimePinUiState()

    data object RepeatPin: OneTimePinUiState()

    data class Success(
        val previousState: OneTimePinUiState,
    ): OneTimePinUiState()

    data class Error(
        val previousState: OneTimePinUiState,
    ): OneTimePinUiState()
}
