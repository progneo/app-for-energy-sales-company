package com.enplus.energetic.di

import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.AuthStateManagerImpl
import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PasswordManagerImpl
import com.enplus.energetic.data.preference.PhoneNumberManager
import com.enplus.energetic.data.preference.PhoneNumberManagerImpl
import com.enplus.energetic.data.preference.PinManager
import com.enplus.energetic.data.preference.PinManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SharedPreferencesManagerModule {

    @Binds
    internal abstract fun authStateManager(authStateManagerImpl: AuthStateManagerImpl): AuthStateManager

    @Binds
    internal abstract fun passwordManager(passwordManagerImpl: PasswordManagerImpl): PasswordManager

    @Binds
    internal abstract fun phoneNumberManager(phoneNumberManagerImpl: PhoneNumberManagerImpl): PhoneNumberManager

    @Binds
    internal abstract fun pinManager(pinManagerImpl: PinManagerImpl): PinManager
}
