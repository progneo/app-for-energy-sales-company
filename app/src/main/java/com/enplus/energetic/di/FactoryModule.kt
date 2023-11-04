package com.enplus.energetic.di

import com.enplus.energetic.ui.factories.MeterUiModelFactory
import com.enplus.energetic.ui.factories.MeterUiModelFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FactoryModule {

    @Binds
    @Singleton
    abstract fun bindMeterUiModelFactory(
        meterUiModelFactory: MeterUiModelFactoryImpl,
    ): MeterUiModelFactory
}
