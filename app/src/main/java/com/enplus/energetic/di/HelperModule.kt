package com.enplus.energetic.di

import com.enplus.energetic.util.VibrationManager
import com.enplus.energetic.util.VibrationManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HelperModule {

    @Binds
    @Singleton
    internal abstract fun bindVibrationManager(
        vibrationManagerImpl: VibrationManagerImpl,
    ): VibrationManager
}
