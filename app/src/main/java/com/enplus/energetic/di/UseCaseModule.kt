package com.enplus.energetic.di

import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.domain.usecase.GetPersonDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindGetPersonDataUseCase(
        getPersonDataUseCaseImpl: GetPersonDataUseCaseImpl,
    ): GetPersonDataUseCase
}
