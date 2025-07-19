package com.noahspott.callyourmom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ContactCard(contact: Contact) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            hoveredElevation = 8.dp,
            focusedElevation = 8.dp,
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column {
                Image(
                    painter = painterResource (id = R.drawable.contact),
                    contentDescription = "default contact image",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

            }
            Column {
                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Column (
                horizontalAlignment = Alignment.End
            ) {
                Row {
                    Text(
                        text = contact.daysSinceLastContact.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Row {
                    Text(
                        text = "DAYS",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Column {
                IconButton(
                    onClick = { println("Called!") },
                    modifier = Modifier
                        .size(48.dp)
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colorScheme.primary)
                    ) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Call ${contact.name}",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    val sampleContact = Contact(
        id = "1",
        name = "Maria Johnson",
        daysSinceLastContact = 3,
        phoneNumber = "5702431651",
        imageUrl = null // or use a real image URL if testing
    )

    ContactCard(contact = sampleContact)
}