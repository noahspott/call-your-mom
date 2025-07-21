package com.noahspott.callyourmom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.noahspott.callyourmom.data.local.model.Interaction
import kotlinx.coroutines.flow.Flow

@Dao
interface InteractionDao {
    @Upsert
    suspend fun upsert(interaction: Interaction)
    @Delete
    suspend fun delete(interaction: Interaction)

    @Query("""
        SELECT * FROM interaction
        WHERE contactId = :contactId
        """)
    fun getAllContactInteractions(contactId: Int): Flow<List<Interaction>>

    @Query("""
        SELECT * FROM interaction
        WHERE contactId = :contactId
        ORDER BY timestamp DESC
        LIMIT 1
    """)
    fun getLastContactInteraction(contactId: Int): Flow<Interaction>
}