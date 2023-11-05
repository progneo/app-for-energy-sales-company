package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface AuthStateManager {

    suspend fun save(newState: Boolean)

    suspend fun get(): Boolean

    suspend fun remove()
}

@Singleton
internal class AuthStateManagerImpl @Inject constructor(
    private val encryptedSharedPreferences: SharedPreferences,
) : AuthStateManager {

    override suspend fun save(newState: Boolean) {
        with(encryptedSharedPreferences.edit()) {
            putBoolean(AUTH_STATE_KEY, newState)
            apply()
        }
    }

    override suspend fun get(): Boolean {
        return encryptedSharedPreferences.getBoolean(AUTH_STATE_KEY, false)
    }

    override suspend fun remove() {
        with(encryptedSharedPreferences.edit()) {
            remove(AUTH_STATE_KEY)
            apply()
        }
    }

    companion object {
        private const val AUTH_STATE_KEY = "AUTH_STATE_KEY"
    }
}
