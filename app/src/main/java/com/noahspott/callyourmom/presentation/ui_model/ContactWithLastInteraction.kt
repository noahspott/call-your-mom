package com.noahspott.callyourmom.presentation.ui_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Embedded
import androidx.room.Relation
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.local.model.Interaction
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

data class ContactWithLastInteraction(
    @Embedded val contact: Contact,

    @Relation(
        parentColumn = "id",
        entityColumn = "contactId",
        entity = Interaction::class,
        projection = ["id", "contactId", "timestamp"]
    )
    val lastInteraction: Interaction?
) {
    val daysSinceLastInteraction: Int
        @RequiresApi(Build.VERSION_CODES.O)
        get() = lastInteraction?.let { interaction ->
            val interactionDate = Instant.ofEpochMilli(interaction.timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
            val today = LocalDate.now()
            ChronoUnit.DAYS.between(interactionDate, today).toInt()
        } ?: 0
}
