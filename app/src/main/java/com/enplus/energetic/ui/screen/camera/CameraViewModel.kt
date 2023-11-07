package com.enplus.energetic.ui.screen.camera

import android.util.Log
import androidx.camera.core.ImageProxy
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.enplus.energetic.util.toInputImage
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<CameraUiState>(CameraUiState.WaitingForCapture)
    val uiState = _uiState.asStateFlow()

    fun setLoading() {
        _uiState.tryEmit(CameraUiState.Loading)
    }

    fun resetState() {
        _uiState.tryEmit(CameraUiState.WaitingForCapture)
    }

    fun recognizeText(image: ImageProxy) {
        val inputImage = image.toInputImage()

        if (inputImage == null) {
            _uiState.tryEmit(CameraUiState.Error)
            return
        }

        recognizeImage(inputImage)
    }

    private fun recognizeImage(image: InputImage) {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        recognizer.process(image)
            .addOnSuccessListener { visionText ->
                for (block in visionText.textBlocks) {
                    for (line in block.lines) {
                        for (element in line.elements) {
                            if (element.text.length == 9 && element.text.isDigitsOnly()) {
                                _uiState.tryEmit(CameraUiState.Success(element.text))
                                return@addOnSuccessListener
                            }
                        }
                    }
                }
                _uiState.tryEmit(CameraUiState.Error)
            }
            .addOnFailureListener { exception ->
                Log.e("TextRecognition", "Error recognizing image", exception)
                _uiState.tryEmit(CameraUiState.Error)
            }
    }
}
