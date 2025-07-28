package com.noahspott.callyourmom.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AddContactScreen(navController: NavController, modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text("Add Contact Screen")
    }
}