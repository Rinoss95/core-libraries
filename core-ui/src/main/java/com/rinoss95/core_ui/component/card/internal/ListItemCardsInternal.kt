package com.rinoss95.core_ui.component.card.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.TitleMedium

/**
 * [headerSubtitle] is subjected to the [headerTitle] in order to be shown
 */
@Composable
internal fun ListItemCardsFilling(
    avatarText: String,
    headerTitle: String,
    headerSubtitle: String,
    trailingContent: (@Composable BoxScope.() -> Unit)?,
) {
    val hasAvatar = avatarText.isNotBlank()
    val hasHeaderTitle = headerTitle.isNotBlank()
    val hasHeaderSubtitle = headerSubtitle.isNotBlank()
    val hasTrailingContent = trailingContent != null

    Row(
        modifier = Modifier.heightIn(min = 80.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (hasAvatar || hasHeaderTitle || hasHeaderSubtitle) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (hasAvatar) {
                    TextAvatar(
                        modifier = Modifier.padding(end = 16.dp),
                        avatarText = avatarText,
                        backgroundColor = MaterialTheme.colorScheme.primary,
                        textColor = MaterialTheme.colorScheme.surface,
                    )
                }

                if (hasHeaderTitle) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        TitleMedium(text = headerTitle)

                        if (hasHeaderSubtitle) {
                            BodyMedium(
                                modifier = Modifier.padding(top = 4.dp),
                                text = headerSubtitle,
                            )
                        }
                    }
                }
            }
        }

        if (hasTrailingContent) {
            Box(
                modifier = Modifier.sizeIn(
                    minWidth = 80.dp,
                    minHeight = 80.dp,
                ),
                content = {
                    trailingContent!!()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemCardPreview() {
    ListItemCardsFilling(
        avatarText = "A",
        headerTitle = "Header",
        headerSubtitle = "Subtitle",
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Red)
                .width(80.dp)
                .height(80.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemCardPreview2() {
    ListItemCardsFilling(
        avatarText = "A",
        headerTitle = "Header",
        headerSubtitle = "",
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Red)
                .width(80.dp)
                .height(80.dp),
        )
    }
}