package com.enplus.energetic.di

import com.enplus.energetic.data.repository.PersonDataRepositoryImpl
import com.enplus.energetic.domain.repository.PersonDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindPersonDataRepository(
        personDataRepositoryImpl: PersonDataRepositoryImpl,
    ): PersonDataRepository
}
