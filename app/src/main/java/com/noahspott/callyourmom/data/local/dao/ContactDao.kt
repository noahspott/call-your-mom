package com.noahspott.callyourmom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.noahspott.callyourmom.data.local.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)
    @Delete
    suspend fun  deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getAllContacts(): Flow<List<Contact>>
}