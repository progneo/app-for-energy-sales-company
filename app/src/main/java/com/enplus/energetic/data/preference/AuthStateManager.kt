package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthStateManager @Inject constructor(
    private val _encryptedSharedPreferences: SharedPreferences,
) {

    companion object {
        const val AUTH_STATE_KEY = "AUTH_STATE_KEY"
    }

    var authState: Boolean
        get() {
            return _encryptedSharedPreferences.getBoolean(AUTH_STATE_KEY, false)
        }
        set(value) {
            with(_encryptedSharedPreferences.edit()) {
                putBoolean(AUTH_STATE_KEY, value)
                apply()
            }
        }
}
