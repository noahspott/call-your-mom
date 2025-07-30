package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.local.model.Interaction
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddContactScreenViewModel(private val contactRepository: ContactRepository, private val interactionRepository: InteractionRepository) : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onPhoneChange(newPhone: String) {
        _phone.value = newPhone
    }

    fun onSave() {
        viewModelScope.launch {
            val contactId = contactRepository.insertContact(Contact(
                id = 0,
                name = name.value,
                phoneNumber = phone.value,
            ))

            interactionRepository.upsert(Interaction(
                id = 0,
                contactId = contactId.toInt(),
                timestamp = System.currentTimeMillis()
            ))
        }
    }
}