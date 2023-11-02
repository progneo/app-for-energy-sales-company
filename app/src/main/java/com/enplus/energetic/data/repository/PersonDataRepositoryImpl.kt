package com.enplus.energetic.data.repository

import com.enplus.energetic.data.api.PersonDataService
import com.enplus.energetic.data.mappers.PersonDataApiToDomainMapper
import com.enplus.energetic.domain.entities.PersonData
import com.enplus.energetic.domain.repository.PersonDataRepository
import javax.inject.Inject

internal class PersonDataRepositoryImpl @Inject constructor(
    private val service: PersonDataService,
    private val apiToDomain: PersonDataApiToDomainMapper,
) : PersonDataRepository {

    override suspend fun getPersonData(data: String): PersonData {

       return apiToDomain(service.getPersonData(data))

//        return PersonData(
//            personAccountId = 0,
//            address = "Address",
//            metersList = listOf(),
//        )
    }
}
