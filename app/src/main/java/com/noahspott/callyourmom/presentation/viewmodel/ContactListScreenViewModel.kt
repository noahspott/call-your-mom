package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Interaction
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository
import com.noahspott.callyourmom.presentation.ContactCardClickEvent
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

private const val MILLIS_PER_DAY = 1000 * 60 * 60 * 24

class ContactListScreenViewModel(private val contactRepository: ContactRepository, private val interactionRepository: InteractionRepository): ViewModel() {
    private val _contactCards = MutableStateFlow<List<ContactCardModel>>(emptyList())
    val contactCards: StateFlow<List<ContactCardModel>> = _contactCards

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _uiEvent = Channel<ContactCardClickEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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

    fun onContactCardClick(contact: ContactCardModel) {
        println("Clicked ${contact.name}")
        viewModelScope.launch {
            _uiEvent.send(ContactCardClickEvent.NavigateToContactDetail(contact.contactId))
        }
    }

    init {
        viewModelScope.launch {
            contactRepository.getAllContactsWithLastTimestamp()
                .onStart { _isLoading.value = true }
                .collect { contactsList ->
                    _contactCards.value = contactsList.map { contact ->
                        val daysSince = contact.lastTimestamp.let { timestamp ->
                            val now = System.currentTimeMillis()
                            if (timestamp == 0L) {
                                -1
                            } else {
                                maxOf(((now - timestamp) / MILLIS_PER_DAY).toInt(), 0)
                            }
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