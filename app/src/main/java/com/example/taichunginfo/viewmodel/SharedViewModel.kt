package com.example.taichunginfo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taichunginfo.model.DangerousWaterInfo
import com.example.taichunginfo.model.SeaAreasInfo

class SharedViewModel: ViewModel() {
    var selectedSeaAreaInfo by mutableStateOf<SeaAreasInfo?>(null)
    var selectedDangerousWaterInfo by mutableStateOf<DangerousWaterInfo?>(null)
    var isEnglish by mutableStateOf(false)
}