package com.example.taichunginfo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlowerInfo(
    @SerialName("縣市")
    val county: String,
    @SerialName("縣市別代碼")
    val countyCode: String,
    @SerialName("行政區")
    val area: String,
    @SerialName("行政區代碼")
    val areaCode: String,
    @SerialName("地點")
    val location: String,
    @SerialName("地址")
    val address: String,
    @SerialName("花種")
    val flower: String,
    @SerialName("觀賞時期")
    val time: String
)