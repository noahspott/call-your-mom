package com.noahspott.callyourmom.presentation.viewmodel

import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository

class ViewContactScreenViewModel(
    private val contactRepository: ContactRepository,
    private val interactionRepository: InteractionRepository
) {

}