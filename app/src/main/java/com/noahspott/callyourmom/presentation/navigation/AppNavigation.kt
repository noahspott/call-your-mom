package com.noahspott.callyourmom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noahspott.callyourmom.presentation.ui.screens.ContactListScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "contactListScreen") {
        composable("contactListScreen") {
            ContactListScreen(navController, modifier)
        }
    }
}
