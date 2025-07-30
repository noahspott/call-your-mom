package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository

@Suppress("UNCHECKED_CAST")
class ContactListScreenViewModelFactory(
    private val contactRepository: ContactRepository,
    private val interactionRepository: InteractionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactListScreenViewModel::class.java)) {
            return ContactListScreenViewModel(contactRepository, interactionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
