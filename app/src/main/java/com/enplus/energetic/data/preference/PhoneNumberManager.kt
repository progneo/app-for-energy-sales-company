package com.enplus.energetic.data.preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

interface PhoneNumberManager {

    suspend fun save(newPhoneNumber: String)

    suspend fun get(): String?

    suspend fun remove()
}

@Singleton
internal class PhoneNumberManagerImpl @Inject constructor(
    private val encryptedSharedPreferences: SharedPreferences,
) : PhoneNumberManager {

    override suspend fun save(newPhoneNumber: String) {
        with(encryptedSharedPreferences.edit()) {
            putString(PHONE_NUMBER_KEY, newPhoneNumber)
            apply()
        }
    }

    override suspend fun get(): String? {
        return encryptedSharedPreferences.getString(PHONE_NUMBER_KEY, null)
    }

    override suspend fun remove() {
        with(encryptedSharedPreferences.edit()) {
            remove(PHONE_NUMBER_KEY)
            apply()
        }
    }

    companion object {
        private const val PHONE_NUMBER_KEY = "PHONE_NUMBER_KEY"
    }
}
