package com.example.taichunginfo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.taichunginfo.model.SeaAreasInfo
import com.example.taichunginfo.viewmodel.SharedViewModel

@Composable
fun SeaAreasInfoCard(
    seaAreasInfo: SeaAreasInfo,
    sharedViewModel: SharedViewModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(seaAreasInfo.photoUrl1),
                contentDescription = seaAreasInfo.photoDescription1,
                modifier = Modifier
                    .size(128.dp)
                    .padding(end = 16.dp)
            )
            Column {
                if (sharedViewModel.isEnglish) {
                    Text(seaAreasInfo.viewpointEn)
                    Text(seaAreasInfo.viewpointDescriptionEn)
                } else {
                    Text(seaAreasInfo.viewpointZh)
                    Text(seaAreasInfo.viewpointDescriptionZh)
                }
            }
        }

    }
}