package com.noahspott.callyourmom

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Contact::class,
        parentColumns = ["id"],
        childColumns = ["contactId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Interaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val contactId: Int,
    val date: Long
)
