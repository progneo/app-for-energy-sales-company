package com.enplus.energetic.ui.entities

import com.enplus.energetic.ui.util.JsonNavType
import com.google.gson.Gson

class PersonDataArgType : JsonNavType<PersonDataUiModel>() {

    override fun fromJsonParse(value: String): PersonDataUiModel =
        Gson().fromJson(value, PersonDataUiModel::class.java)

    override fun PersonDataUiModel.getJsonParse(): String = Gson().toJson(this)
}
