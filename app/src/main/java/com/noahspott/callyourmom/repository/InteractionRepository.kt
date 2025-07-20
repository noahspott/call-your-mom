package com.noahspott.callyourmom.repository

import com.noahspott.callyourmom.data.database.AppDatabase
import com.noahspott.callyourmom.data.model.Interaction

class InteractionRepository(private val db : AppDatabase) {
    suspend fun upsert(interaction: Interaction){
        db.interactionDao.upsert(interaction)
    }

    suspend fun delete(interaction: Interaction){
        db.interactionDao.delete(interaction)
    }

    fun getAllContactInteractions(contactId: Int){
        db.interactionDao.getAllContactInteractions(contactId)
    }

    fun getLastContactInteraction(contactId: Int){
        db.interactionDao.getLastContactInteraction(contactId)
    }
}