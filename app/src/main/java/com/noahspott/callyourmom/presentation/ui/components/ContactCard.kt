package com.noahspott.callyourmom.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.noahspott.callyourmom.R
import com.noahspott.callyourmom.presentation.ui_model.ContactCardModel


@Composable
fun ContactCard(contact: ContactCardModel, callButtonHandler: (ContactCardModel)-> Unit) {
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Image(
                        painter = painterResource (id = R.drawable.contact),
                        contentDescription = "default contact image",
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = contact.name,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start,
                    )
                }

            }
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column (
                        horizontalAlignment = Alignment.End
                    ) {
                        Row {
                            Text(
                                text = contact.daysSinceLastInteraction.toString(),
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.End
                            )
                        }
                        Row {
                            Text(
                                text = "DAYS",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        IconButton(
                            onClick = { callButtonHandler(contact)},
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
    }
}