package com.enplus.energetic.di

import com.enplus.energetic.ui.util.FlashlightManager
import com.enplus.energetic.ui.util.FlashlightManagerImpl
import com.enplus.energetic.ui.util.VibrationManager
import com.enplus.energetic.ui.util.VibrationManagerImpl
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
    abstract fun bindVibrationManager(
        vibrationManagerImpl: VibrationManagerImpl,
    ): VibrationManager

    @Binds
    @Singleton
    abstract fun bindFlashlightManager(
        flashlightManagerImpl: FlashlightManagerImpl,
    ): FlashlightManager
}
