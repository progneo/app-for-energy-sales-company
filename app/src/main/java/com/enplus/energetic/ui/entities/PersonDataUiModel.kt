package com.enplus.energetic.ui.entities

import android.net.Uri
import com.google.gson.Gson

data class PersonDataUiModel(
    val personAccountId: Long,
    val address: String,
    val metersList: List<MeterUiModel>?,
) {
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}
