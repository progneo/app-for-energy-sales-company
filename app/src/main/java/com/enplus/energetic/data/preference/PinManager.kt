package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PinManager @Inject constructor(
    private val _encryptedSharedPreferences: SharedPreferences,
) {

    companion object {
        const val PIN_KEY = "PIN_KEY"
    }

    var pin: String?
        get() {
            return _encryptedSharedPreferences.getString(PIN_KEY, null)
        }
        set(value) {
            with(_encryptedSharedPreferences.edit()) {
                putString(PIN_KEY, value)
                apply()
            }
        }
}
