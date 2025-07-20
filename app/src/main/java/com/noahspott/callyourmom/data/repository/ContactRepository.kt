package com.noahspott.callyourmom.data.repository

import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.local.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val db: AppDatabase) {
    suspend fun upsertContact(contact: Contact) {
        db.contactDao.upsertContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        db.contactDao.deleteContact(contact)
    }

    fun getAllContacts(): Flow<List<Contact>> {
        return db.contactDao.getAllContacts()
    }
}