package com.enplus.energetic.util

import android.os.Build
import android.os.VibrationEffect

sealed class VibrationEffects(val vibrationEffect: VibrationEffect) {
    data object Success : VibrationEffects(
        vibrationEffect = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK)
        } else {
            VibrationEffect.createOneShot(25, VibrationEffect.DEFAULT_AMPLITUDE)
        },
    )

    data object Error : VibrationEffects(
        vibrationEffect = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE),
    )
}
