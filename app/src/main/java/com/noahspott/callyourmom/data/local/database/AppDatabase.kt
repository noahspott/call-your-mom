package com.noahspott.callyourmom.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noahspott.callyourmom.data.local.dao.ContactDao
import com.noahspott.callyourmom.data.local.dao.InteractionDao
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.local.model.Interaction

@Database(
    entities = [Contact::class, Interaction::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val contactDao: ContactDao
    abstract val interactionDao: InteractionDao
}