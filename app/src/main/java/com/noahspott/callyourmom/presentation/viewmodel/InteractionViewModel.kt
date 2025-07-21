package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.noahspott.callyourmom.data.local.model.Interaction
import com.noahspott.callyourmom.data.repository.InteractionRepository
import kotlinx.coroutines.launch

class InteractionViewModel(private val repository: InteractionRepository): ViewModel() {
    fun getAllContactInteractions(contactId: Int) = repository
        .getAllContactInteractions(contactId)

    fun getLastContactInteraction(contactId: Int) = repository
        .getLastContactInteraction(contactId)

    fun upsertInteraction(interaction: Interaction) {
        viewModelScope.launch {
            repository.upsert(interaction)
        }
    }

    fun deleteInteraction(interaction: Interaction) {
        viewModelScope.launch {
            repository.delete(interaction)
        }
    }
}