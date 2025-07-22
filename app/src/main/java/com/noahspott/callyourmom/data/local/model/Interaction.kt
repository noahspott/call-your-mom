package com.noahspott.callyourmom.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Contact::class,
        parentColumns = ["id"],
        childColumns = ["contactId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["contactId"])]
)
data class Interaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val contactId: Int,
    val timestamp: Long
)
