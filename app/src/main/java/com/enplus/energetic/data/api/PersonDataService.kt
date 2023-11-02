package com.enplus.energetic.data.api

import com.enplus.energetic.data.api.entities.PersonDataResponse

internal interface PersonDataService {

    //retrofit GET()
    fun getPersonData(data: String): PersonDataResponse
}
