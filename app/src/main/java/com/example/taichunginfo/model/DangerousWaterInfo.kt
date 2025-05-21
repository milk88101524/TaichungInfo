package com.example.taichunginfo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DangerousWaterInfo(
    @SerialName("編號")
    val id: String,
    @SerialName("行政區")
    val district: String,
    @SerialName("主要危險水域地點")
    val dangerousWaterLocation: String,
    @SerialName("水域主管機關")
    val waterAgency: String,
    @SerialName("限制活動")
    val restriction: String,
    @SerialName("違規罰則")
    val penalty: String,
    @SerialName("法令依據")
    val law: String,
    @SerialName("座標系統")
    val coordinateSystem: String,
    @SerialName("限制區域座標")
    val restrictionAreaCoordinate: String,
    @SerialName("限制區域文字描述")
    val restrictionAreaDescription: String,
    @SerialName("公告網址1")
    val noticeUrl1: String,
    @SerialName("公告網址2")
    val noticeUrl2: String,
    @SerialName("法令網址1")
    val lawUrl1: String,
    @SerialName("法令網址2")
    val lawUrl2: String?
)