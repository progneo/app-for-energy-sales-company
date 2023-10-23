package com.enplus.energetic.ui.screen.camera

sealed class CameraUiState {

    data object WaitingForCapture : CameraUiState()
    data object Loading : CameraUiState()
    data object Error : CameraUiState()
    data class Success(
        val text: String,
    ) : CameraUiState()
}
