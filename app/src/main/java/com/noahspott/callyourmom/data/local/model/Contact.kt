package com.noahspott.callyourmom.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val imageUrl: String? = null
)