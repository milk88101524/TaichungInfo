package com.example.taichunginfo

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.taichunginfo.model.DangerousWaterInfo
import com.example.taichunginfo.model.FlowerInfo
import com.example.taichunginfo.model.SeaAreasInfo
import com.example.taichunginfo.model.StoreInfo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Repository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchFlowerInfo(): SnapshotStateList<FlowerInfo> {
        val flowerInfos = mutableStateListOf<FlowerInfo>()
        try {
            val response = client.get("https://datacenter.taichung.gov.tw/swagger/OpenData/f116d1db-56f7-4984-bad8-c82e383765c0")
            if (response.status == HttpStatusCode.OK) {
                for (flowerInfo in response.body<List<FlowerInfo>>()) {
                    flowerInfos.add(flowerInfo)
                }
                println(flowerInfos)
            } else {
                println("Error: ${response.status}")
            }
        } catch (e: Exception) {
            println(e.message)
        }

        return flowerInfos
    }

    suspend fun fetchSeaAreasInfo(): SnapshotStateList<SeaAreasInfo> {
        val seaAreasInfos = mutableStateListOf<SeaAreasInfo>()

        try {
            val response = client.get("https://datacenter.taichung.gov.tw/swagger/OpenData/38476e5e-9288-4b83-bb33-384b1b36c570")
            if (response.status == HttpStatusCode.OK) {
                for (seaAreasInfo in response.body<List<SeaAreasInfo>>()) {
                    seaAreasInfos.add(seaAreasInfo)
                }
                println(seaAreasInfos)
            } else {
                println("Error: ${response.status}")
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return seaAreasInfos
    }

    suspend fun fetchStoreInfo(): SnapshotStateList<StoreInfo> {
        val infos = mutableStateListOf<StoreInfo>()

        try {
            val response = client.get("https://datacenter.taichung.gov.tw/swagger/OpenData/2980962e-18e0-486c-909c-0618c0b18aa3")
            if (response.status == HttpStatusCode.OK) {
                for (info in response.body<List<StoreInfo>>()) {
                    infos.add(info)
                }
                println(infos)
            } else {
                println("Error: ${response.status}")
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return infos
    }

    suspend fun fetchDangerousWaterInfo(): SnapshotStateList<DangerousWaterInfo> {
        val dangerousWaterInfos = mutableStateListOf<DangerousWaterInfo>()

        try {
            val response = client.get("https://datacenter.taichung.gov.tw/swagger/OpenData/90fb8fe6-4cc3-4173-af1d-0773e759682e")
            if (response.status == HttpStatusCode.OK) {
                for (dangerousWaterInfo in response.body<List<DangerousWaterInfo>>()) {
                    dangerousWaterInfos.add(dangerousWaterInfo)
                }
                println(dangerousWaterInfos)
            } else {
                println("Error: ${response.status}")
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return dangerousWaterInfos
    }
}