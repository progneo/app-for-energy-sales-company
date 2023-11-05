package com.enplus.energetic.ui.screen.main

import com.enplus.energetic.ui.entities.PersonDataUiModel

sealed class MainUiState {

    data object Waiting : MainUiState()
    data object Loading : MainUiState()
    data object Error : MainUiState()
    data class Success(
        val personData: PersonDataUiModel,
    ) : MainUiState()
}
