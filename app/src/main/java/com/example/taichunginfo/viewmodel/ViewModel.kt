package com.example.taichunginfo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taichunginfo.Repository
import com.example.taichunginfo.model.DangerousWaterInfo
import com.example.taichunginfo.model.FlowerInfo
import com.example.taichunginfo.model.SeaAreasInfo
import com.example.taichunginfo.model.StoreInfo
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    private val repo = Repository()
    private val _flowerInfos = mutableStateListOf<FlowerInfo>()
    private val _seaAreasInfos = mutableStateListOf<SeaAreasInfo>()
    private val _storeInfos = mutableStateListOf<StoreInfo>()
    private val _dangerousWaterInfos = mutableStateListOf<DangerousWaterInfo>()
    val flowerInfos: SnapshotStateList<FlowerInfo> = _flowerInfos
    val seaAreasInfos: SnapshotStateList<SeaAreasInfo> = _seaAreasInfos
    val storeInfos: SnapshotStateList<StoreInfo> = _storeInfos
    val dangerousWaterInfos: SnapshotStateList<DangerousWaterInfo> = _dangerousWaterInfos

    var isLoading = mutableStateOf(false)

    fun fetchFlowerInfo() {
        viewModelScope.launch {
            isLoading.value = true
            _flowerInfos.clear()
            _flowerInfos.addAll(repo.fetchFlowerInfo())
            isLoading.value = false
        }
    }

    fun fetchSeaAreasInfo() {
        viewModelScope.launch {
            isLoading.value = true
            _seaAreasInfos.clear()
            _seaAreasInfos.addAll(repo.fetchSeaAreasInfo())
            isLoading.value = false
        }
    }

    fun fetchStoreInfo() {
        viewModelScope.launch {
            isLoading.value = true
            _storeInfos.clear()
            _storeInfos.addAll(repo.fetchStoreInfo())
            isLoading.value = false
        }
    }

    fun fetchDangerousWaterInfo() {
        viewModelScope.launch {
            isLoading.value = true
            _dangerousWaterInfos.clear()
            _dangerousWaterInfos.addAll(repo.fetchDangerousWaterInfo())
            isLoading.value = false
        }
    }
}