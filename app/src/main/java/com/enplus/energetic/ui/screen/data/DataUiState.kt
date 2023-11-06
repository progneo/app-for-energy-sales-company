package com.enplus.energetic.ui.screen.data

sealed class DataUiState {

    data object Loading : DataUiState()
    data object Error : DataUiState()
    data object Content : DataUiState()
}
