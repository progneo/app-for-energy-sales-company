package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface PinManagerManager {

    suspend fun save(newPin: String)

    suspend fun get(): String?
}

@Singleton
class PinManagerImpl @Inject constructor(
    private val encryptedSharedPreferences: SharedPreferences,
) : PinManagerManager {

    override suspend fun save(newPin: String) {
        with(encryptedSharedPreferences.edit()) {
            putString(PIN_KEY, newPin)
            apply()
        }
    }

    override suspend fun get(): String? {
        return encryptedSharedPreferences.getString(PIN_KEY, null)
    }

    companion object {
        private const val PIN_KEY = "PIN_KEY"
    }
}
