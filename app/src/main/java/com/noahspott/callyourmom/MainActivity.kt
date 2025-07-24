package com.noahspott.callyourmom

import AppHeader
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.noahspott.callyourmom.presentation.navigation.AppNavigation
import com.noahspott.callyourmom.presentation.ui.theme.CallYourMomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallYourMomTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val appBarTitle = when (currentRoute) {
                    "contactListScreen" -> "Call Your Mom!"
                    "addContactScreen" -> "New Contact"
                    else -> "Call Your Mom"
                }

                Scaffold(
                    topBar = {
                        AppHeader(
                            title = appBarTitle
                        )
                    },
                ) { padding ->
                    AppNavigation(navController = navController, modifier = Modifier.padding(padding))
                }
            }
        }
    }
}