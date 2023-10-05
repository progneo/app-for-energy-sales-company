package com.enplus.energetic.di

import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.AuthStateManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthStateManagerModule {

    @Binds
    internal abstract fun authStateManager(authStateManagerImpl: AuthStateManagerImpl): AuthStateManager
}
