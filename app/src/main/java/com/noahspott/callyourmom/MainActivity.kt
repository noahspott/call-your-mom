package com.noahspott.callyourmom

import AppHeader
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import com.noahspott.callyourmom.data.local.database.AppDatabase
import com.noahspott.callyourmom.data.repository.ContactRepository
import com.noahspott.callyourmom.data.repository.InteractionRepository
import com.noahspott.callyourmom.presentation.ui.screens.ContactListScreen
import com.noahspott.callyourmom.presentation.ui.theme.CallYourMomTheme
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModel
import com.noahspott.callyourmom.presentation.viewmodel.ContactScreenViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var contactScreenViewModel: ContactScreenViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getInstance(applicationContext)
        val contactRepo = ContactRepository(db)
        val interactionRepo = InteractionRepository(db)

        contactScreenViewModel = ViewModelProvider(
            this,
            ContactScreenViewModelFactory(contactRepo, interactionRepo)
        )[ContactScreenViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            CallYourMomTheme {
                Scaffold(
                    topBar = {
                        AppHeader(
                            title = "Call Your Mom"
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { contactScreenViewModel::addContactHandler.invoke() }) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add new contact")
                        }
                    }
                ) {
                    ContactListScreen(viewModel = contactScreenViewModel)
                }

            }
        }
    }
}