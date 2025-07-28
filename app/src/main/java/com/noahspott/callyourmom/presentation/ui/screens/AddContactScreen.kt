package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.noahspott.callyourmom.CallYourMomApplication
import com.noahspott.callyourmom.presentation.viewmodel.AddContactScreenViewModel
import com.noahspott.callyourmom.presentation.viewmodel.AddContactScreenViewModelFactory

@Composable
fun AddContactScreen(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    val app = context.applicationContext as CallYourMomApplication
    val viewModel: AddContactScreenViewModel = viewModel(
        factory = AddContactScreenViewModelFactory(app.contactRepo, app.interactionRepo)
    )
    val name by viewModel.name.collectAsState()
    val phone by viewModel.phone.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            label = {
                Text("Name")
            },
            onValueChange = viewModel::onNameChange,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = phone,
            label = {
                Text("Phone")
            },
            onValueChange = viewModel::onPhoneChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Button(
            onClick = {
                viewModel::onSave.invoke()
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}