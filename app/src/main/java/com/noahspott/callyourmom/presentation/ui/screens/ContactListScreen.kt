package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.noahspott.callyourmom.presentation.ui.components.ContactCardList
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModel

@Composable
fun ContactListScreen(
    viewModel: ContactScreenViewModel
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val contactCards by viewModel.contactCards.collectAsState()

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
        ContactCardList(contactCards, viewModel::callButtonHandler)
    }
}