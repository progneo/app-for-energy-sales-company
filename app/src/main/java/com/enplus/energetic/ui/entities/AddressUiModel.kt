package com.enplus.energetic.ui.entities

import android.net.Uri
import com.google.gson.Gson

data class AddressUiModel(
    val address: String,
    val flatDataList: List<FlatData>,
) {
    data class FlatData(
        val personId: Long,
        val flatNumber: Int,
        val metersCount: Int, //TODO возможно заменить на лист счетчиков
    )

    override fun toString(): String = Uri.encode(Gson().toJson(this))
}
