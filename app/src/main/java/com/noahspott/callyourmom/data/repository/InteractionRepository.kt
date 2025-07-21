package com.noahspott.callyourmom.data.repository

import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.local.model.Interaction
import kotlinx.coroutines.flow.Flow

class InteractionRepository(private val db : AppDatabase) {
    suspend fun upsert(interaction: Interaction){
        db.interactionDao.upsert(interaction)
    }

    suspend fun delete(interaction: Interaction){
        db.interactionDao.delete(interaction)
    }

    fun getAllContactInteractions(contactId: Int): Flow<List<Interaction>> {
        return db.interactionDao.getAllContactInteractions(contactId)
    }

    fun getLastContactInteraction(contactId: Int): Flow<Interaction> {
        return db.interactionDao.getLastContactInteraction(contactId)
    }
}