package com.noahspott.callyourmom.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.noahspott.callyourmom.CallYourMomApplication
import com.noahspott.callyourmom.presentation.ui.components.ContactCardList
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModel
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactListScreen(navController: NavController) {
    val context = LocalContext.current
    val app = context.applicationContext as CallYourMomApplication
    val contactScreenViewModel: ContactScreenViewModel = viewModel(
        factory = ContactScreenViewModelFactory(app.contactRepo, app.interactionRepo)
    )

    val isLoading by contactScreenViewModel.isLoading.collectAsState()
    val contactCards by contactScreenViewModel.contactCards.collectAsState()

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
        ContactCardList(contactCards, contactScreenViewModel::callButtonHandler)
    }
}