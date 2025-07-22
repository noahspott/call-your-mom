package com.noahspott.callyourmom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noahspott.callyourmom.data.repository.InteractionRepository

@Suppress("UNCHECKED_CAST")
class InteractionViewModelFactory(
    private val interactionRepository: InteractionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InteractionViewModel::class.java)) {
            return InteractionViewModel(interactionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}