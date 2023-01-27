package com.rinoss95.core_ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedContentCard(
    headerTitle: String = "",
    headerSubtitle: String = "",
    headerAvatarText: String = "",
    onIconClick: (() -> Unit)? = null,
    iconContent: (@Composable () -> Unit)? = null,
    imageContent: @Composable () -> Unit,
    bodyTextTitle: String = "",
    bodyTextSubtitle: String = "",
    bodyTextContent: String = "",
    primaryButtonText: String = "",
    secondaryButtonText: String = "",
    onPrimaryButtonClick: (() -> Unit)? = null,
    onSecondaryButtonClick: (() -> Unit)? = null,
) {
    OutlinedCard {
        this.ContentCardFields(
            headerTitle = headerTitle,
            headerSubtitle = headerSubtitle,
            headerAvatarText = headerAvatarText,
            onIconClick = onIconClick,
            iconContent = iconContent,
            imageContent = imageContent,
            bodyTextTitle = bodyTextTitle,
            bodyTextSubtitle = bodyTextSubtitle,
            bodyTextContent = bodyTextContent,
            primaryButtonText = primaryButtonText,
            secondaryButtonText = secondaryButtonText,
            onPrimaryButtonClick = onPrimaryButtonClick,
            onSecondaryButtonClick = onSecondaryButtonClick,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedContentCardPreview() {
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
}