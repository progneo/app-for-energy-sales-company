package com.enplus.energetic.di

import com.enplus.energetic.data.api.PersonDataService
import com.enplus.energetic.data.api.PersonDataServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    //TODO change to retrofit
    @Binds
    @Singleton
    abstract fun bindPersonDataService(
        personDataServiceImpl: PersonDataServiceImpl,
    ): PersonDataService
}
