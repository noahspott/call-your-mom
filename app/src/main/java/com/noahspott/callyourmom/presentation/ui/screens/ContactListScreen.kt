package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.noahspott.callyourmom.CallYourMomApplication
import com.noahspott.callyourmom.presentation.ui.components.ContactCardList
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModel
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModelFactory

@Composable
fun ContactListScreen(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    val app = context.applicationContext as CallYourMomApplication
    val contactScreenViewModel: ContactScreenViewModel = viewModel(
        factory = ContactScreenViewModelFactory(app.contactRepo, app.interactionRepo)
    )

    val isLoading by contactScreenViewModel.isLoading.collectAsState()
    val contactCards by contactScreenViewModel.contactCards.collectAsState()

    Column(modifier = modifier) {
        if(isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Loading your contact list...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {navController.navigate(route = "addContactScreen")}) {
                    Icon(Icons.Filled.AddCircle, "Add a new contact")
                }
                Text("Add a new contact")
            }
            ContactCardList(contactCards, contactScreenViewModel::callButtonHandler)
        }
    }


}