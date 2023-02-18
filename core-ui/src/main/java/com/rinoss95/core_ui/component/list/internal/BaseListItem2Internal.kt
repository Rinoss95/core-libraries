package com.rinoss95.core_ui.component.list.internal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.LabelMedium

internal object ListItemContentPadding {
    val Small = PaddingValues(16.dp, 8.dp, 24.dp, 8.dp)
    val Large = PaddingValues(16.dp, 12.dp, 24.dp, 12.dp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun RawListItem(
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)?,
    trailing: (@Composable () -> Unit)?,
    overlineText: String,
    headlineText: String,
    supportingText: String,
    hasDivider: Boolean,
    verticalAlignment: Alignment.Vertical,
    padding: PaddingValues,
) {
    val hasLeading = leading != null
    val hasTrailing = trailing != null
    val hasOverlineText = overlineText.isNotBlank()
    val hasHeadline = headlineText.isNotBlank()
    val hasSupporting = supportingText.isNotBlank()

    Surface(
        modifier = modifier,
        shape = ListItemDefaults.shape,
        color = ListItemDefaults.containerColor,
        contentColor = ListItemDefaults.contentColor,
        tonalElevation = ListItemDefaults.Elevation,
        shadowElevation = ListItemDefaults.Elevation,
    ) {
        Column {
            Row(
                modifier = Modifier.padding(padding),
                verticalAlignment = verticalAlignment,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (hasLeading) {
                    leading!!()
                }

                if (hasOverlineText || hasHeadline || hasSupporting) {
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        if (hasOverlineText) {
                            LabelMedium(
                                text = overlineText,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }

                        if (hasHeadline) {
                            BodyLarge(
                                text = headlineText,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }

                        if (hasSupporting) {
                            BodyMedium(text = supportingText)
                        }
                    }
                }

                if (hasTrailing) {
                    trailing!!()
                }
            }

            if (hasDivider) {
                Divider(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 24.dp,
                    )
                )
            }
        }
    }
}