package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PasswordManager @Inject constructor(
    private val _encryptedSharedPreferences: SharedPreferences,
) {

    companion object {
        const val PASSWORD_KEY = "PASSWORD_KEY"
    }

    var password: String?
        get() {
            return _encryptedSharedPreferences.getString(PASSWORD_KEY, null)
        }
        set(value) {
            with(_encryptedSharedPreferences.edit()) {
                putString(PASSWORD_KEY, value)
                apply()
            }
        }
}
