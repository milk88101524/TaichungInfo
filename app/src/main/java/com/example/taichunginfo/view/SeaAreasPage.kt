package com.example.taichunginfo.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taichunginfo.components.FlowerInfoCard
import com.example.taichunginfo.components.SeaAreasInfoCard
import com.example.taichunginfo.viewmodel.SharedViewModel
import com.example.taichunginfo.viewmodel.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeaAreasPage(
    navController: NavController,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel,
    viewModel: ViewModel = ViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchSeaAreasInfo()
    }

    Scaffold(
        modifier = modifier
    ) {
        if (viewModel.isLoading.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                if (sharedViewModel.isEnglish) {
                    Button(
                        modifier = Modifier.padding(16.dp),
                        onClick = { sharedViewModel.isEnglish = false }
                    ) {
                        Text("EN")
                    }
                } else {
                    Button(
                        modifier = Modifier.padding(16.dp),
                        onClick = { sharedViewModel.isEnglish = true }
                    ) {
                        Text("中")
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    items(viewModel.seaAreasInfos) { info ->
                        SeaAreasInfoCard(info, sharedViewModel) {
                            sharedViewModel.selectedSeaAreaInfo = info
                            navController.navigate("seaAreasDetail")
                        }
                    }
                }
            }
        }
    }
}