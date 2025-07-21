package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository): ViewModel() {

    val contacts: Flow<List<Contact>> = repository.getAllContacts()

    fun upsertContact(contact: Contact) {
        viewModelScope.launch {
            repository.upsertContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repository.deleteContact(contact)
        }
    }
}