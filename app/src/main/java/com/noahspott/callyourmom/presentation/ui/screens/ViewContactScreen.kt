package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.noahspott.callyourmom.CallYourMomApplication
import com.noahspott.callyourmom.presentation.viewmodel.ViewContactScreenViewModel
import com.noahspott.callyourmom.presentation.viewmodel.ViewContactScreenViewModelFactory

@Composable
fun ViewContactScreen(navController: NavController, modifier: Modifier, contactId: Int) {
    val context = LocalContext.current
    val app = context.applicationContext as CallYourMomApplication
//    val viewModel: ViewContactScreenViewModel = viewModel(
//        factory = ViewContactScreenViewModelFactory(app.contactRepo, app.interactionRepo)
//    )
//    val name by viewModel.name.collectAsState()
//    val phone by viewModel.phone.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("View Contact Screen")
    }
}