package com.example.taichunginfo.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.taichunginfo.components.FlowerInfoCard
import com.example.taichunginfo.components.StoreInfoCard
import com.example.taichunginfo.viewmodel.ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StorePage(
    viewModel: ViewModel = ViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchStoreInfo()
    }

    Scaffold {
        if (viewModel.isLoading.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                items(viewModel.storeInfos) { info ->
                    StoreInfoCard(info)
                }
            }
        }
    }
}