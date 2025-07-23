package com.noahspott.callyourmom.presentation.ui_model

data class ContactWithLastTimestamp(
    val contactId: Int,
    val name: String,
    val imageUrl: String? = null,
    val phoneNumber: String? = null,
    val daysSinceLastInteraction: Int? = 0,
    val lastTimestamp: Long
) {

}