package com.noahspott.callyourmom.data.repository

import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import com.noahspott.callyourmom.presentation.ui_model.ContactWithLastTimestamp
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val db: AppDatabase) {
    suspend fun insertContact(contact: Contact) {
        db.contactDao.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact) {
        db.contactDao.updateContact(contact)
    }

    suspend fun upsertContact(contact: Contact) {
        db.contactDao.upsertContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        db.contactDao.deleteContact(contact)
    }

    fun getAllContacts(): Flow<List<Contact>> {
        return db.contactDao.getAllContacts()
    }

    fun getAllContactCards(): Flow<List<ContactCardModel>> {
        return db.contactDao.getAllContactCards()
    }

    fun getAllContactsWithLastTimestamp(): Flow<List<ContactWithLastTimestamp>> {
        return db.contactDao.getAllContactsWithLastTimestamp()
    }
}