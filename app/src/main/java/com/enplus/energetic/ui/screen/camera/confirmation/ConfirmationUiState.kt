package com.enplus.energetic.ui.screen.camera.confirmation

import com.enplus.energetic.ui.entities.PersonDataUiModel

sealed class ConfirmationUiState {

    data object Waiting : ConfirmationUiState()
    data object Loading : ConfirmationUiState()
    data object Error : ConfirmationUiState()
    data class Success(
        val personData: PersonDataUiModel,
    ) : ConfirmationUiState()
}
