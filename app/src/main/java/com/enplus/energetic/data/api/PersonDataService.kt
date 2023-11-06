package com.enplus.energetic.data.api

import com.enplus.energetic.data.api.entities.PersonDataResponse
import com.enplus.energetic.ui.util.Mocks.getMockPersonDataResponse
import javax.inject.Inject

interface PersonDataService {

    //retrofit GET()
    fun getPersonData(data: String): PersonDataResponse
}

//TODO remove when add retrofit
//mock retrofit
class PersonDataServiceImpl @Inject constructor()  : PersonDataService {

    override fun getPersonData(data: String): PersonDataResponse = getMockPersonDataResponse()
}
