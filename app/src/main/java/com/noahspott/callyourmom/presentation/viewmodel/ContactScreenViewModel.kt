package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Interaction
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ContactScreenViewModel(private val contactRepository: ContactRepository, private val interactionRepository: InteractionRepository): ViewModel() {
    private val _contactCards = MutableStateFlow<List<ContactCardModel>>(emptyList())
    val contactCards: StateFlow<List<ContactCardModel>> = _contactCards

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun callButtonHandler(contact: ContactCardModel) {
        viewModelScope.launch {
            interactionRepository.upsert(
                Interaction(id = 0,
                    contactId = contact.contactId,
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }

    fun addContactHandler() {
        println("Add contact handler!")
    }

    init {
        viewModelScope.launch {
            contactRepository.getAllContactsWithLastTimestamp()
                .onStart { _isLoading.value = true }
                .collect { contactsList ->
                    _contactCards.value = contactsList.map { contact ->
                        val daysSince = contact.lastTimestamp.let { timestamp ->
                            val now = System.currentTimeMillis()
                            ((now - timestamp) / (1000 * 60 * 60 * 24)).toInt()
                        }

                        ContactCardModel(
                            contactId = contact.contactId,
                            name = contact.name,
                            imageUrl = contact.imageUrl,
                            phoneNumber = contact.phoneNumber,
                            daysSinceLastInteraction = daysSince
                        )
                    }
                    _isLoading.value = false
                }
        }

    }
}