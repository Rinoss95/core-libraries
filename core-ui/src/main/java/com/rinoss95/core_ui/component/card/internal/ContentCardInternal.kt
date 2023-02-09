package com.rinoss95.core_ui.component.card.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.LabelLarge
import com.rinoss95.core_ui.component.text.TitleMedium

@Composable
internal fun ContentCardInternal(
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
    Column {
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
}

@Composable
private fun Header(
    headerTitle: String,
    headerSubtitle: String,
    headerAvatarText: String,
    onIconClick: (() -> Unit)?,
    iconContent: (@Composable () -> Unit)?,
) {
    val hasAvatar = headerAvatarText.isNotBlank()
    val hasHeaderTitle = headerTitle.isNotBlank()
    val hasHeaderSubtitle = headerSubtitle.isNotBlank()
    val hasIconButton = onIconClick != null && iconContent != null

    if (hasAvatar ||
        hasHeaderTitle ||
        hasHeaderSubtitle ||
        hasIconButton
    ) {
        Box(
            modifier = Modifier
                .height(72.dp)
                .padding(
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
                if (hasAvatar) {
                    TextAvatar(
                        headerAvatarText,
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.surface,
                        modifier = Modifier.padding(end = 16.dp),
                    )
                }

                if (hasHeaderTitle) {
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        TitleMedium(
                            text = headerTitle,
                            maxLines = if (hasHeaderSubtitle) 1 else 2,
                            overflow = TextOverflow.Ellipsis,
                        )

                        if (hasHeaderSubtitle) {
                            BodyMedium(
                                text = headerSubtitle,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }
                }

                if (hasIconButton) {
                    IconButton(
                        modifier = Modifier.size(48.dp),
                        onClick = onIconClick!!,
                        content = iconContent!!,
                    )
                }
            }
        }
    }
}

@Composable
private fun ImageContent(
    imageContent: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier.heightIn(max = 188.dp)
    ) {
        imageContent()
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
    val hasBodyTextTitle = bodyTextTitle.isNotBlank()
    val hasBodyTextSubtitle = bodyTextSubtitle.isNotBlank()
    val hasBodyTextContent = bodyTextContent.isNotBlank()
    val hasPrimaryButton = secondaryButtonText.isNotBlank() && onPrimaryButtonClick != null
    val hasSecondaryButton = secondaryButtonText.isNotBlank() && onSecondaryButtonClick != null

    if (
        hasBodyTextTitle ||
        hasBodyTextSubtitle ||
        hasBodyTextContent ||
        hasPrimaryButton ||
        hasSecondaryButton
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                if (hasBodyTextTitle) {
                    BodyLarge(text = bodyTextTitle)
                }
                if (hasBodyTextSubtitle) {
                    BodyMedium(text = bodyTextSubtitle)
                }

                if (hasBodyTextContent) {
                    BodyMedium(
                        modifier = Modifier.padding(top = 32.dp),
                        text = bodyTextContent,
                    )
                }

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
}

@Preview(showBackground = true)
@Composable
private fun ContentCardPreview() {
    ContentCardInternal(
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
                    .heightIn(20.dp)
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