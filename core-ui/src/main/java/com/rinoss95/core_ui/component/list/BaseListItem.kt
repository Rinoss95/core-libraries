package com.rinoss95.core_ui.component.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.LabelSmall
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.text.TitleMedium
import com.rinoss95.core_ui.util.uiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseListItem(
    modifier: Modifier = Modifier,
    headlineText: String = "",
    supportingText: String = "",
    trailingText: String = "",
    trailingIcon: ImageData? = null,
    leadingAvatarText: String = "",
    leadingIcon: ImageData? = null,
    hasDivider: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val clickable = onClick?.let {
        Modifier.clickable(onClick = it)
    } ?: Modifier

    Column(modifier) {
        ListItem(
            modifier = Modifier.then(clickable),

            headlineText = {
                if (headlineText.isNotBlank()) {
                    BodyLarge(
                        headlineText,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }
            },

            supportingText = {
                if (supportingText.isNotBlank()) {
                    BodyMedium(
                        supportingText,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            },

            leadingContent = {
                if (leadingAvatarText.isNotBlank()) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(color = MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        TitleMedium(
                            text = leadingAvatarText,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }

                if (leadingIcon != null) {
                    ImageComponent(
                        modifier = Modifier.size(18.dp),
                        imageData = leadingIcon
                    )
                }
            },

            trailingContent = {
                if (trailingText.isNotBlank()) {
                    LabelSmall(
                        text = trailingText,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                if (trailingIcon != null) {
                    ImageComponent(
                        modifier = Modifier.size(24.dp),
                        imageData = trailingIcon
                    )
                }
            }
        )

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


@Preview
@Composable
private fun BaseListItemPreview() {
    BaseListItem(
        headlineText = "Ciao",
        supportingText = "Come",
        trailingIcon = ImageData.IconImageData(
            Icons.Filled.KeyboardArrowRight,
            R.string.expand_content.uiText,
        ),
        hasDivider = true,
    )
}

@Preview
@Composable
private fun BaseListItemLeadingIconPreview() {
    BaseListItem(
        headlineText = "Ciao",
        supportingText = "Come",
        leadingIcon = ImageData.IconImageData(
            Icons.Filled.KeyboardArrowRight,
            R.string.expand_content.uiText,
        ),
        hasDivider = true,
    )
}

@Preview
@Composable
private fun BaseListItemLeadingAvatarPreview() {
    BaseListItem(
        headlineText = "Ciao",
        supportingText = "Come",
        leadingAvatarText = "A",
        hasDivider = true,
    )
}