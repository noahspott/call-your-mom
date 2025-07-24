package com.noahspott.callyourmom

import AppHeader
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.noahspott.callyourmom.presentation.navigation.AppNavigation
import com.noahspott.callyourmom.presentation.ui.theme.CallYourMomTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallYourMomTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        AppHeader(
                            title = "Call Your Mom"
                        )
                    },
                ) { padding ->
                    AppNavigation(navController = navController, modifier = Modifier.padding(padding))
                }
            }
        }
    }
}