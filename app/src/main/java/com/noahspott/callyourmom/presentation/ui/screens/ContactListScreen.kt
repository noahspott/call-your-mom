package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.runtime.Composable
import com.noahspott.callyourmom.presentation.ui.components.ContactCardList
import com.noahspott.callyourmom.presentation.viewmodel.ContactViewModel

@Composable
fun ContactListScreen(
    viewModel: ContactViewModel
) {
    ContactCardList(viewModel.contactCards)
}