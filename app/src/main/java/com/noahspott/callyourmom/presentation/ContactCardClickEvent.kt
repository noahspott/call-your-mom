package com.noahspott.callyourmom.presentation

import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel

sealed class ContactCardClickEvent {
    data class NavigateToContactDetail(val contactId: Int) : ContactCardClickEvent()
}

