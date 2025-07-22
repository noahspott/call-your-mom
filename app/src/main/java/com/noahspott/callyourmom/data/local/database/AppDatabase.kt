package com.noahspott.callyourmom.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.noahspott.callyourmom.data.local.dao.ContactDao
import com.noahspott.callyourmom.data.local.dao.InteractionDao
import com.noahspott.callyourmom.data.local.model.Contact
import com.noahspott.callyourmom.data.local.model.Interaction

@Database(entities = [Contact::class, Interaction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val contactDao: ContactDao
    abstract val interactionDao: InteractionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
