package com.example.taichunginfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taichunginfo.ui.theme.TaichungInfoTheme
import com.example.taichunginfo.view.HomePage
import com.example.taichunginfo.view.SeaAreasDetail
import com.example.taichunginfo.viewmodel.SharedViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val sharedViewModel: SharedViewModel = viewModel()

            TaichungInfoTheme {
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomePage(
                            navController = navController,
                            sharedViewModel = sharedViewModel
                        )
                    }
                    composable("seaAreasDetail") {
                        SeaAreasDetail(
                            sharedViewModel = sharedViewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}