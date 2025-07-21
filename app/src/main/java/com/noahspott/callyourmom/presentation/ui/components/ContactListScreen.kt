package com.noahspott.callyourmom.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.noahspott.callyourmom.presentation.ui.theme.CallYourMomTheme
import com.noahspott.callyourmom.presentation.viewmodel.ContactViewModel

@Composable
fun ContactListScreen(viewModel: ContactViewModel) {
    val contacts by viewModel.contacts.collectAsState(initial = emptyList())

    LazyColumn {
        items(contacts) {contact ->
            ContactCard(contact = contact)
        }
    }
}