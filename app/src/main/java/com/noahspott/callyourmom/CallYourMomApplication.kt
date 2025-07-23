package com.noahspott.callyourmom

import android.app.Application
import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository

class CallYourMomApplication : Application() {
    private lateinit var database: AppDatabase
    private lateinit var contactRepository: ContactRepository
    private lateinit var interactionRepository: InteractionRepository

    val contactRepo: ContactRepository
        get() = contactRepository

    val interactionRepo: InteractionRepository
        get() = interactionRepository

    override fun onCreate() {
        super.onCreate()

        database = AppDatabase.getInstance(applicationContext)
        contactRepository = ContactRepository(database)
        interactionRepository = InteractionRepository(database)

    }
}