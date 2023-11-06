package com.enplus.energetic.domain.repository

import com.enplus.energetic.domain.entities.PersonData

interface PersonDataRepository {

    suspend fun getPersonData(data: String): PersonData?
}
