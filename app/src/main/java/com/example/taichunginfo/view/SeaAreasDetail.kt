package com.example.taichunginfo.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.taichunginfo.model.SeaAreasInfo
import com.example.taichunginfo.viewmodel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeaAreasDetail(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val info = sharedViewModel.selectedSeaAreaInfo
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (sharedViewModel.isEnglish) {
                        Text(info?.viewpointEn ?: "No Data")
                    } else {
                        Text(info?.viewpointZh ?: "No Data")
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            if (info != null) {
                Image(
                    painter = rememberAsyncImagePainter(info.photoUrl1),
                    contentDescription = info.photoDescription1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                if (sharedViewModel.isEnglish) {
                    Text(info.viewpointDescriptionEn)
                    Text("Address：${info.viewpointEnAddress}")
                    Text("Phone：${info.viewpointPhone}")
                } else {
                    Text(info.viewpointDescriptionZh)
                    Text("地址：${info.viewpointZhAddress}")
                    Text("電話：${info.viewpointPhone}")
                }
                Text(
                    buildAnnotatedString {
                        withLink(
                            LinkAnnotation.Url(
                                info.url,
                                TextLinkStyles(style = SpanStyle(color = Color.Blue))
                            )
                        ) {
                            append(info.url)
                        }
                    }
                )
            }
        }
    }
}