package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddContactScreenViewModel(contactRepository: ContactRepository, interactionRepository: InteractionRepository) : ViewModel() {
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
        println(name)
        println(phone)
        println("onSave clicked!")
    }
}