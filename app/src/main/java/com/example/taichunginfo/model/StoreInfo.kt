package com.example.taichunginfo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreInfo(
    @SerialName("編號")
    val id: String,
    @SerialName("標題")
    val title: String,
    @SerialName("簡介說明")
    val description: String,
    @SerialName("電話")
    val phone: String,
    @SerialName("緯度")
    val latitude: String,
    @SerialName("經度")
    val longitude: String,
    @SerialName("停車資訊")
    val parkingInfo: String
)
