package com.noahspott.callyourmom.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noahspott.callyourmom.presentation.ui.screens.AddContactScreen
import com.noahspott.callyourmom.presentation.ui.screens.ContactListScreen
import com.noahspott.callyourmom.presentation.ui.screens.ViewContactScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "contactListScreen") {
        composable("contactListScreen") {
            ContactListScreen(navController, modifier)
        }
        composable("addContactScreen") {
            AddContactScreen(navController, modifier)
        }
        composable("viewContactScreen/{contactId}") { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("contactId")?.toIntOrNull()
            if (contactId != null) {
                ViewContactScreen(navController, modifier, contactId = contactId)
            }
        }
    }
}
