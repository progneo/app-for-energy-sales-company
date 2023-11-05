package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface PinManager {

    suspend fun save(newPin: String)

    suspend fun get(): String?

    suspend fun equal(pin: String): Boolean

    suspend fun checkIsSet(): Boolean

    suspend fun remove()
}

@Singleton
internal class PinManagerImpl @Inject constructor(
    private val encryptedSharedPreferences: SharedPreferences,
) : PinManager {

    override suspend fun save(newPin: String) {
        with(encryptedSharedPreferences.edit()) {
            putString(PIN_KEY, newPin)
            apply()
        }
    }

    override suspend fun get(): String? {
        return encryptedSharedPreferences.getString(PIN_KEY, null)
    }

    override suspend fun equal(pin: String): Boolean {
        return encryptedSharedPreferences.getString(PIN_KEY, null)?.let { it == pin } ?: false
    }

    override suspend fun checkIsSet(): Boolean {
        return encryptedSharedPreferences.getString(PIN_KEY, null)?.let { true } ?: false
    }

    override suspend fun remove() {
        with(encryptedSharedPreferences.edit()) {
            remove(PIN_KEY)
            apply()
        }
    }

    companion object {
        private const val PIN_KEY = "PIN_KEY"
    }
}
