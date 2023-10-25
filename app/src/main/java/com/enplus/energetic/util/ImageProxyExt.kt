package com.enplus.energetic.util

import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage

@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
fun ImageProxy.toInputImage(): InputImage? {
    val mediaImage = this.image
    var image: InputImage? = null

    if (mediaImage != null) {
        image = InputImage.fromMediaImage(mediaImage, this.imageInfo.rotationDegrees)
    }

    return image
}
