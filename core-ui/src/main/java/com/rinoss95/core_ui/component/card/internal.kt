package com.rinoss95.core_ui.component.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.LabelLarge
import com.rinoss95.core_ui.component.text.TitleMedium

@Composable
internal fun ColumnScope.ContentCardFields(
    headerTitle: String,
    headerSubtitle: String,
    headerAvatarText: String,
    onIconClick: (() -> Unit)?,
    iconContent: (@Composable () -> Unit)?,
    imageContent: @Composable () -> Unit,
    bodyTextTitle: String,
    bodyTextSubtitle: String,
    bodyTextContent: String,
    primaryButtonText: String,
    secondaryButtonText: String,
    onPrimaryButtonClick: (() -> Unit)?,
    onSecondaryButtonClick: (() -> Unit)?,
) {
    Header(
        headerTitle = headerTitle,
        headerSubtitle = headerSubtitle,
        headerAvatarText = headerAvatarText,
        onIconClick = onIconClick,
        iconContent = iconContent,
    )

    ImageContent(imageContent)

    BodyTextContent(
        bodyTextTitle = bodyTextTitle,
        bodyTextSubtitle = bodyTextSubtitle,
        bodyTextContent = bodyTextContent,
        primaryButtonText = primaryButtonText,
        secondaryButtonText = secondaryButtonText,
        onPrimaryButtonClick = onPrimaryButtonClick,
        onSecondaryButtonClick = onSecondaryButtonClick,
    )
}

@Composable
private fun Header(
    headerTitle: String,
    headerSubtitle: String,
    headerAvatarText: String,
    onIconClick: (() -> Unit)?,
    iconContent: (@Composable () -> Unit)?,
) {
    Box(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 12.dp,
            end = 4.dp,
            bottom = 12.dp,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (headerAvatarText.isNotBlank()) {
                TextAvatar(
                    headerAvatarText,
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.surface,
                    modifier = Modifier.padding(end = 16.dp),
                )
            }

            Column(
                modifier = Modifier.weight(1f),
            ) {
                if (headerTitle.isNotBlank()) {
                    TitleMedium(text = headerTitle)
                }

                if (headerSubtitle.isNotBlank()) {
                    BodyMedium(text = headerSubtitle)
                }
            }

            if (onIconClick != null && iconContent != null) {
                IconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onIconClick,
                    content = iconContent,
                )
            }
        }
    }
}

@Composable
private fun ImageContent(
    imageContent: @Composable () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .heightIn(0.dp, 188.dp)
    ) {
        item {
            imageContent()
        }
    }
}

@Composable
private fun BodyTextContent(
    bodyTextTitle: String,
    bodyTextSubtitle: String,
    bodyTextContent: String,
    primaryButtonText: String,
    secondaryButtonText: String,
    onPrimaryButtonClick: (() -> Unit)?,
    onSecondaryButtonClick: (() -> Unit)?,
) {
    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        Column {
            if (bodyTextTitle.isNotBlank()) {
                BodyLarge(text = bodyTextTitle)
            }
            if (bodyTextSubtitle.isNotBlank()) {
                BodyMedium(text = bodyTextSubtitle)
            }

            if (bodyTextContent.isNotBlank()) {
                BodyMedium(
                    modifier = Modifier.padding(top = 32.dp),
                    text = bodyTextContent,
                )
            }

            val hasPrimaryButton = secondaryButtonText.isNotBlank() && onPrimaryButtonClick != null
            val hasSecondaryButton =
                secondaryButtonText.isNotBlank() && onSecondaryButtonClick != null
            if (hasPrimaryButton or hasSecondaryButton) {
                Row(
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    if (hasSecondaryButton) {
                        OutlinedButton(
                            modifier = Modifier.padding(end = 8.dp),
                            onClick = onSecondaryButtonClick!!,
                        ) {
                            LabelLarge(text = secondaryButtonText)
                        }
                    }

                    if (hasPrimaryButton) {
                        Button(
                            onClick = onPrimaryButtonClick!!,
                        ) {
                            LabelLarge(text = primaryButtonText)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header(
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
    )
}