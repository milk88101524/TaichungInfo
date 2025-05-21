package com.example.taichunginfo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taichunginfo.model.FlowerInfo

@Composable
fun FlowerInfoCard(flowerInfo: FlowerInfo) {
    Box(
        modifier = Modifier.padding(top = 10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = flowerInfo.flower,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(flowerInfo.location)
                Text(flowerInfo.address)
                Text(
                    "觀賞時期: ${flowerInfo.time}",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
        Card(
            modifier = Modifier.padding(end = 8.dp),
//            border = BorderStroke(1.dp, Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(flowerInfo.county)
                Text(flowerInfo.area)
            }
        }
    }
}