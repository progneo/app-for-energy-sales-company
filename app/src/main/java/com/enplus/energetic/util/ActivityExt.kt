package com.enplus.energetic.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings

fun Activity.goToAppSetting() {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null),
    )
    startActivity(intent)
}
