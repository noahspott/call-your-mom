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

    fun insertDummyData() {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val dummyInteractions = listOf(
                Interaction(id = 0, contactId = 1, timestamp = now - 100000000L), // 1+ days ago
                Interaction(id = 0, contactId = 2, timestamp = now - 200000000L),
                Interaction(id = 0, contactId = 3, timestamp = now - 300000000L),
                Interaction(id = 0, contactId = 4, timestamp = now - 400000000L),
                Interaction(id = 0, contactId = 5, timestamp = now - 500000000L),
                Interaction(id = 0, contactId = 6, timestamp = now - 600000000L),
                Interaction(id = 0, contactId = 7, timestamp = now - 700000000L),
                Interaction(id = 0, contactId = 8, timestamp = now - 800000000L),
                Interaction(id = 0, contactId = 9, timestamp = now - 900000000L),
                Interaction(id = 0, contactId = 10, timestamp = now - 1000000000L),
            )

            dummyInteractions.forEach { interaction ->
                repository.upsert(interaction)
            }
        }
    }

}