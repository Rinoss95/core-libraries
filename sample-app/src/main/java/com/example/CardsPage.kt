package com.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.card.ContentCard
import com.rinoss95.core_ui.component.card.ElevatedContentCard
import com.rinoss95.core_ui.component.card.OutlinedContentCard
import com.rinoss95.core_ui.component.text.HeadlineLarge
import com.rinoss95.core_ui.component.text.TitleLarge

@Composable
fun CardsPage() {
    Column(
        Modifier.padding(bottom = 16.dp),
    ) {
        TitleLarge(text = "Cards")

        Box(modifier = Modifier.padding(top = 24.dp))

        ElevatedCard {
            HeadlineLarge(
                "ElevatedCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        Card {
            HeadlineLarge(
                "FilledCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        OutlinedCard {
            HeadlineLarge(
                "OutlinedCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "ContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        ContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )

        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "OutlinedContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        OutlinedContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )

        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "ElevatedContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        ElevatedContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )
    }
}