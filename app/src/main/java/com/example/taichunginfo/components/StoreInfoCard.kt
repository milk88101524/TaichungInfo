package com.example.taichunginfo.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taichunginfo.model.StoreInfo

@Composable
fun StoreInfoCard(
    info: StoreInfo
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
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = info.title,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(vertical = 8.dp)
                )
            }
        }
        Card(
            modifier = Modifier.padding(end = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
        ) {
            Text(
                info.phone,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}