package com.enplus.energetic.ui.util

import android.content.Context
import android.hardware.camera2.CameraManager
import android.widget.Toast
import javax.inject.Inject

interface FlashlightManager {

    fun setFlashlightMode(context: Context, enabled: Boolean)
}

class FlashlightManagerImpl @Inject constructor() : FlashlightManager {

    override fun setFlashlightMode(context: Context, enabled: Boolean) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraID = cameraManager.cameraIdList[0]

        try {
            cameraManager.setTorchMode(cameraID, enabled)
        } catch (exception: Exception) {
            Toast.makeText(context, "На вашем устройстве нет фонарика", Toast.LENGTH_SHORT).show()
        }
    }
}
