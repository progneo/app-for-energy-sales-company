package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhoneNumberManager @Inject constructor(
    private val _encryptedSharedPreferences: SharedPreferences,
) {

    companion object {
        const val PHONE_NUMBER_KEY = "PHONE_NUMBER_KEY"
    }

    var phoneNumber: String?
        get() {
            return _encryptedSharedPreferences.getString(PHONE_NUMBER_KEY, null)
        }
        set(value) {
            with(_encryptedSharedPreferences.edit()) {
                putString(PHONE_NUMBER_KEY, value)
                apply()
            }
        }
}
