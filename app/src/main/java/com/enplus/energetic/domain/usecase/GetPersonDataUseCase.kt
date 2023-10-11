package com.enplus.energetic.domain.usecase

import com.enplus.energetic.domain.entities.PersonData
import com.enplus.energetic.domain.repository.PersonDataRepository
import javax.inject.Inject

interface GetPersonDataUseCase {

    suspend operator fun invoke(string: String): PersonData
}

internal class GetPersonDataUseCaseImpl @Inject constructor(
    private val personDataRepository: PersonDataRepository,
) : GetPersonDataUseCase {

    override suspend operator fun invoke(string: String): PersonData {
        return personDataRepository.getPersonData(string)
    }
}
