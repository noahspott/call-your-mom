package com.noahspott.callyourmom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import com.noahspott.callyourmom.presentation.ui_model.ContactWithLastTimestamp
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getAllContacts(): Flow<List<Contact>>

    @Query("""
        SELECT 
            contact.id AS contactId, 
            contact.name AS name,
            contact.imageUrl AS imageUrl,
            contact.phoneNumber AS phoneNumber,
            CAST((strftime('%s','now') - MAX(interaction.timestamp) / 1000) / 86400 AS INTEGER) AS daysSinceLastInteraction
        FROM contact
        LEFT JOIN interaction ON interaction.contactId = contact.id
        GROUP BY contact.id
        ORDER BY daysSinceLastInteraction DESC
    """)
    fun getAllContactCards(): Flow<List<ContactCardModel>>

    @Query("""
        SELECT 
            contact.id AS contactId, 
            contact.name AS name,
            contact.imageUrl AS imageUrl,
            contact.phoneNumber AS phoneNumber,
            MAX(interaction.timestamp) AS lastTimestamp
        FROM contact
        LEFT JOIN interaction ON interaction.contactId = contact.id
        GROUP BY contact.id
        ORDER BY lastTimestamp ASC
    """)
    fun getAllContactsWithLastTimestamp(): Flow<List<ContactWithLastTimestamp>>
}