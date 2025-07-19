package com.example.callyourmom

data class Contact (
    val id: String,
    val name: String,
    val daysSinceLastContact: Int,
    val imageUrl: String? = null
)