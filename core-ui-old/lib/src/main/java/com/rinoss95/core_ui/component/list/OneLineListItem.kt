package com.rinoss95.core_ui.component.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OneLineListItem(
    modifier: Modifier = Modifier,
    leadingText: String = "",
    trailingTitle: String = "",
    trailingSubtitle: String = "",
) {
    Column(modifier = modifier) {
        ListItem(
            headlineText = {
                Row(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = 8.dp,
                    )
                ) {
                    if (leadingText.isNotBlank()) {
                        Text(
                            leadingText,
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(0.7f)
                            .align(Alignment.CenterVertically),
                    ) {

                        val (trailingModifier, trailingAlign) = if (leadingText.isNotBlank()) {
                            Pair(Modifier.fillMaxWidth(), TextAlign.End)
                        } else {
                            Pair(Modifier, TextAlign.Start)
                        }

                        if (trailingTitle.isNotBlank()) {
                            Text(
                                trailingTitle,
                                modifier = trailingModifier,
                                textAlign = trailingAlign,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }

                        if (trailingSubtitle.isNotBlank()) {
                            Text(
                                trailingSubtitle,
                                modifier = trailingModifier,
                                textAlign = trailingAlign,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.W400,
                            )
                        }
                    }
                }
            },
        )
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
private fun OneLineListItemPreview1() {
    OneLineListItem(
        leadingText = "Used currency",
        trailingTitle = "Eastern Caribbean dollar (XCD)",
    )
}

@Preview(showBackground = true)
@Composable
private fun OneLineListItemPreview2() {
    OneLineListItem(
        leadingText = "Used currency",
        trailingTitle = "Eastern Caribbean dollar (XCD)",
        trailingSubtitle = "$"
    )
}

@Preview(showBackground = true)
@Composable
private fun OneLineListItemPreview3() {
    OneLineListItem(
        trailingTitle = "Spanish",
    )
}

@Preview(showBackground = true)
@Composable
private fun OneLineListItemPreview4() {
    OneLineListItem(
        leadingText = "Caaaaaaaaaambodian riel (KHR)",
        trailingTitle = "$"
    )
}