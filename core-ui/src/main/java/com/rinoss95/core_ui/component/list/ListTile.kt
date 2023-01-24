package com.rinoss95.core_ui.component.list

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.R

@Composable
fun ListTile(
    modifier: Modifier = Modifier,
    text: String,
    image: (@Composable () -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Card(
        colors = CardDefaults.cardColors(
            containerColor =
            if (isHovered) MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 24.dp,
                    top = 8.dp,
                    bottom = 8.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (image != null) {
                Box(
                    modifier = Modifier.size(
                        width = 24.dp,
                        height = 24.dp
                    )
                ) {
                    image()
                }
            }

            Text(
                text,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.W400,
            )

            Icon(
                Icons.Filled.KeyboardArrowRight,
                stringResource(R.string.trailing_icon_cd)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListTilePreview() {
    ListTile(
        text = "ciao ciao ciao ciao ciao ciao ciao ciao ciao ciao ",
        image = {
            Icon(
                Icons.Filled.Add,
                "",
            )
        }
    )
}