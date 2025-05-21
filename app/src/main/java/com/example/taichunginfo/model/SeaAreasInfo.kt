package com.example.taichunginfo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeaAreasInfo(
    @SerialName("景點中文名稱")
    val viewpointZh: String,
    @SerialName("景點英文名稱")
    val viewpointEn: String,
    @SerialName("景點特色簡述(中文)")
    val viewpointDescriptionZh: String,
    @SerialName("景點特色簡述(英文)")
    val viewpointDescriptionEn: String,
    @SerialName("海域活動圖式編號")
    val bikeWayNumber: String,
    @SerialName("設施圖示編號")
    val facilityNumber: String,
    @SerialName("經度")
    val longitude: String,
    @SerialName("緯度")
    val latitude: String,
    @SerialName("景點服務電話")
    val viewpointPhone: String,
    @SerialName("景點中文地址")
    val viewpointZhAddress: String,
    @SerialName("景點英文地址")
    val viewpointEnAddress: String,
    @SerialName("開放時間")
    val openTime: String,
    @SerialName("開放時間備註")
    val openTimeComment: String,
    @SerialName("開放時間英文備註")
    val openTimeEnComment: String,
    @SerialName("照片連結網址1")
    val photoUrl1: String,
    @SerialName("照片中文說明1")
    val photoDescription1: String,
    @SerialName("網址")
    val url: String,
    @SerialName("(選填)地圖服務連結")
    val mapUrl: String?
)