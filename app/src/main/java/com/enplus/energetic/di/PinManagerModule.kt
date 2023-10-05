package com.enplus.energetic.di

import com.enplus.energetic.data.preference.PinManager
import com.enplus.energetic.data.preference.PinManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PinManagerModule {

    @Binds
    internal abstract fun pinManager(pinManagerImpl: PinManagerImpl): PinManager
}
