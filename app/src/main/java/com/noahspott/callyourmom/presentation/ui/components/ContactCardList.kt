package com.noahspott.callyourmom.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun ContactCardList(contactCardsFlow: Flow<List<ContactCardModel>>) {
    val contactCards by contactCardsFlow.collectAsState(initial = emptyList())

    if(contactCards.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "You don't have any contacts!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(contactCards) { card ->
                ContactCard(contact = card)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardListPreview() {
    val sampleData = listOf(
        ContactCardModel(contactId = 1, name = "Alice", imageUrl = null, phoneNumber = "555-1234", daysSinceLastInteraction = 3),
        ContactCardModel(contactId = 2, name = "Bob", imageUrl = null, phoneNumber = "555-5678", daysSinceLastInteraction = 7),
        ContactCardModel(contactId = 3, name = "Carol", imageUrl = null, phoneNumber = null, daysSinceLastInteraction = 1),
        ContactCardModel(contactId = 4, name = "David", imageUrl = null, phoneNumber = "555-8765", daysSinceLastInteraction = 5),
        ContactCardModel(contactId = 5, name = "Eve", imageUrl = null, phoneNumber = "555-4321", daysSinceLastInteraction = 10),
        ContactCardModel(contactId = 6, name = "Frank", imageUrl = null, phoneNumber = "555-1122", daysSinceLastInteraction = 2),
        ContactCardModel(contactId = 7, name = "Grace", imageUrl = null, phoneNumber = "555-3344", daysSinceLastInteraction = 4),
        ContactCardModel(contactId = 8, name = "Heidi", imageUrl = null, phoneNumber = "555-5566", daysSinceLastInteraction = 8),
        ContactCardModel(contactId = 9, name = "Ivan", imageUrl = null, phoneNumber = "555-7788", daysSinceLastInteraction = 6),
        ContactCardModel(contactId = 10, name = "Judy", imageUrl = null, phoneNumber = "555-9900", daysSinceLastInteraction = 9),
        ContactCardModel(contactId = 11, name = "Karl", imageUrl = null, phoneNumber = "555-2211", daysSinceLastInteraction = 11),
        ContactCardModel(contactId = 12, name = "Liam", imageUrl = null, phoneNumber = "555-4433", daysSinceLastInteraction = 13),
        ContactCardModel(contactId = 13, name = "Mona", imageUrl = null, phoneNumber = "555-6655", daysSinceLastInteraction = 14),
        ContactCardModel(contactId = 14, name = "Nina", imageUrl = null, phoneNumber = "555-8877", daysSinceLastInteraction = 12),
        ContactCardModel(contactId = 15, name = "Oscar", imageUrl = null, phoneNumber = "555-0099", daysSinceLastInteraction = 15)
    )
    ContactCardList(contactCardsFlow = flowOf(sampleData))
//    ContactCardList(contactCardsFlow = flowOf(emptyList()))
}
