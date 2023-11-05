package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface PasswordManager {

    suspend fun save(newPassword: String)

    suspend fun get(): String?

    suspend fun remove()
}

@Singleton
internal class PasswordManagerImpl @Inject constructor(
    private val encryptedSharedPreferences: SharedPreferences,
) : PasswordManager {

    override suspend fun save(newPassword: String) {
        with(encryptedSharedPreferences.edit()) {
            putString(PASSWORD_KEY, newPassword)
            apply()
        }
    }

    override suspend fun get(): String? {
        return encryptedSharedPreferences.getString(PASSWORD_KEY, null)
    }

    override suspend fun remove() {
        with(encryptedSharedPreferences.edit()) {
            remove(PASSWORD_KEY)
            apply()
        }
    }

    companion object {
        private const val PASSWORD_KEY = "PASSWORD_KEY"
    }
}
