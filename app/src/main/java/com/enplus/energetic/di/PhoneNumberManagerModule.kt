package com.enplus.energetic.di

import com.enplus.energetic.data.preference.PhoneNumberManager
import com.enplus.energetic.data.preference.PhoneNumberManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PhoneNumberManagerModule {

    @Binds
    internal abstract fun phoneNumberManager(phoneNumberManagerImpl: PhoneNumberManagerImpl): PhoneNumberManager
}
