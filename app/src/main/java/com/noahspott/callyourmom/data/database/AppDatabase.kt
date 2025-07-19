package com.noahspott.callyourmom.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noahspott.callyourmom.data.dao.ContactDao
import com.noahspott.callyourmom.data.dao.InteractionDao
import com.noahspott.callyourmom.data.model.Contact
import com.noahspott.callyourmom.data.model.Interaction

@Database(
    entities = [Contact::class, Interaction::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val contactDao: ContactDao
    abstract val interactionDao: InteractionDao
}