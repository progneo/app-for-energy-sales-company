package com.enplus.energetic.ui.entities.navigation

import com.enplus.energetic.ui.entities.AddressUiModel
import com.enplus.energetic.ui.util.JsonNavType
import com.google.gson.Gson

class AddressDataArgsType : JsonNavType<AddressUiModel>() {

    override fun fromJsonParse(value: String): AddressUiModel =
        Gson().fromJson(value, AddressUiModel::class.java)

    override fun AddressUiModel.getJsonParse(): String = Gson().toJson(this)
}
