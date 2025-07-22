package com.noahspott.callyourmom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.presentation.viewmodel.ContactViewModelFactory
import com.noahspott.callyourmom.data.repository.InteractionRepository
import com.noahspott.callyourmom.presentation.viewmodel.InteractionViewModelFactory
import com.noahspott.callyourmom.presentation.ui.screens.ContactListScreen
import com.noahspott.callyourmom.presentation.ui.theme.CallYourMomTheme
import com.noahspott.callyourmom.presentation.viewmodel.ContactViewModel
import com.noahspott.callyourmom.presentation.viewmodel.InteractionViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var contactViewModel: ContactViewModel
    private lateinit var interactionViewModel: InteractionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getInstance(applicationContext)
        val contactRepo = ContactRepository(db)
        val interactionRepo = InteractionRepository(db)

        contactViewModel = ViewModelProvider(
            this,
            ContactViewModelFactory(contactRepo)
        )[ContactViewModel::class.java]

        interactionViewModel = ViewModelProvider(
            this,
            InteractionViewModelFactory(interactionRepo)
        )[InteractionViewModel::class.java]

        // Launch coroutine to insert dummy data
        lifecycleScope.launch {
            contactViewModel.insertDummyData()
        }

        enableEdgeToEdge()
        setContent {
            CallYourMomTheme {
                ContactListScreen(viewModel = contactViewModel)
            }
        }
    }
}