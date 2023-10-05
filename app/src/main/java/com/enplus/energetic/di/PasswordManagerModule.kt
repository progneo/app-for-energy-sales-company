package com.enplus.energetic.di

import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PasswordManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PasswordManagerModule {

    @Binds
    internal abstract fun passwordManager(passwordManagerImpl: PasswordManagerImpl): PasswordManager
}
