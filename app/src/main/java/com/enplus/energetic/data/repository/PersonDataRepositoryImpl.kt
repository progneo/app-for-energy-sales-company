package com.enplus.energetic.data.repository

import com.enplus.energetic.domain.entities.PersonData
import com.enplus.energetic.domain.repository.PersonDataRepository
import javax.inject.Inject

internal class PersonDataRepositoryImpl @Inject constructor() : PersonDataRepository {

    override suspend fun getPersonData(data: String): PersonData {
        return PersonData(
            personAccountId = 0,
            address = "Address",
            metersList = listOf(),
        )
    }
}
