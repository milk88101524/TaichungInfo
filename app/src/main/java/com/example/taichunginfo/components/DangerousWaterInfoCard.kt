package com.example.taichunginfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.taichunginfo.model.DangerousWaterInfo
import com.example.taichunginfo.model.SeaAreasInfo

@Composable
fun DangerousWaterInfoCard(
    info: DangerousWaterInfo,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.padding(top = 10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 10.dp),
            onClick = onClick,
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = info.dangerousWaterLocation,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(vertical = 8.dp)
                )
                Text(info.restriction)
            }
        }
        Card(
            modifier = Modifier.padding(end = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
        ) {
            Text(
                info.district,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}