package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository): ViewModel() {

    val contacts: Flow<List<Contact>> = repository.getAllContacts()

    val contactCards: Flow<List<ContactCardModel>> = repository.getAllContactCards()

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

    fun insertDummyData() {
        viewModelScope.launch {
            val dummyContacts = listOf(
                Contact(id = 0, name = "Alice Johnson", phoneNumber = "555-1234", imageUrl = null),
                Contact(id = 0, name = "Bob Smith", phoneNumber = "555-5678", imageUrl = null),
                Contact(id = 0, name = "Carol Williams", phoneNumber = "555-9012", imageUrl = null),
                Contact(id = 0, name = "David Brown", phoneNumber = "555-3456", imageUrl = null),
                Contact(id = 0, name = "Eva Davis", phoneNumber = "555-7890", imageUrl = null),
                Contact(id = 0, name = "Frank Miller", phoneNumber = "555-2345", imageUrl = null),
                Contact(id = 0, name = "Grace Wilson", phoneNumber = "555-6789", imageUrl = null),
                Contact(id = 0, name = "Hank Moore", phoneNumber = "555-0123", imageUrl = null),
                Contact(id = 0, name = "Ivy Taylor", phoneNumber = "555-4567", imageUrl = null),
                Contact(id = 0, name = "Jack Anderson", phoneNumber = "555-8901", imageUrl = null),
            )

            dummyContacts.forEach { contact ->
                repository.upsertContact(contact)
            }
        }
    }

}