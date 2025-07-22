package com.noahspott.callyourmom.presentation.ui_model

import android.os.Build
import androidx.annotation.RequiresApi
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.local.model.Interaction
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

data class ContactWithInteractions(
    val contact: Contact,
    val interactions: List<Interaction>
) {
    val daysSinceLastInteraction: Int
        @RequiresApi(Build.VERSION_CODES.O)
        get() = interactions.maxOfOrNull { it.timestamp }?.let { lastTimestamp ->
            val lastDate = Instant.ofEpochMilli(lastTimestamp).atZone(ZoneId.systemDefault()).toLocalDate()
            ChronoUnit.DAYS.between(lastDate, LocalDate.now()).toInt()
        } ?: 0
}


