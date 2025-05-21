package com.example.taichunginfo.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taichunginfo.components.DangerousWaterInfoCard
import com.example.taichunginfo.components.FlowerInfoCard
import com.example.taichunginfo.model.DangerousWaterInfo
import com.example.taichunginfo.viewmodel.SharedViewModel
import com.example.taichunginfo.viewmodel.ViewModel
import kotlinx.serialization.SerialName

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DangerousWaterPage(
    viewModel: ViewModel = viewModel(),
    sharedViewModel: SharedViewModel = viewModel()
) {
    var showDetailDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchDangerousWaterInfo()
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
                items(viewModel.dangerousWaterInfos) { info ->
                    DangerousWaterInfoCard(info) {
                        sharedViewModel.selectedDangerousWaterInfo = info
                        showDetailDialog = true
                    }
                }
            }
        }
    }

    if (showDetailDialog) {
        sharedViewModel.selectedDangerousWaterInfo?.let {
            DetailDialog(
                onDismissRequest = { showDetailDialog = false },
                info = it
            )
        }
    }
}

@Composable
fun DetailDialog(
    onDismissRequest: () -> Unit,
    info: DangerousWaterInfo
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(info.dangerousWaterLocation) },
        text = { Column {
            Text(info.law)
            Text(info.penalty)
        } },
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text("OK")
            }
        }
    )
}