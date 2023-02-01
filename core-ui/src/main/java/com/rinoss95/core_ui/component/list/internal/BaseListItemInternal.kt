package com.rinoss95.core_ui.component.list.internal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.LabelSmall
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BaseListItemInternal(
    modifier: Modifier = Modifier,
    headlineText: String,
    supportingText: String,
    trailingText: String,
    trailingIcon: ImageData?,
    leadingAvatarText: String,
    leadingIcon: ImageData?,
    hasDivider: Boolean,
    onClick: (() -> Unit)?,
    bottomContent: (@Composable () -> Unit)?,
) {
    val clickable = onClick?.let {
        Modifier.clickable(onClick = it)
    } ?: Modifier

    val headlineTextContent: @Composable () -> Unit = if (headlineText.isNotBlank()) {
        {
            BodyLarge(
                headlineText,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    } else {
        {}
    }

    val supportingTextContent: (@Composable () -> Unit)? = if (supportingText.isNotBlank()) {
        {
            BodyMedium(
                supportingText,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    } else {
        null
    }

    val leadingContent: (@Composable () -> Unit)? =
        if (leadingAvatarText.isNotBlank() || leadingIcon != null) {
            {
                if (leadingAvatarText.isNotBlank()) {
                    TextAvatar(
                        avatarText = leadingAvatarText,
                        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                        textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                if (leadingIcon != null) {
                    ImageComponent(
                        modifier = Modifier.size(18.dp),
                        imageData = leadingIcon
                    )
                }
            }
        } else {
            null
        }

    val trailingContent: (@Composable () -> Unit)? =
        if (trailingText.isNotBlank() || trailingIcon != null) {
            {
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
        } else {
            null
        }

    Column(modifier) {
        ListItem(
            modifier = Modifier.then(clickable),
            headlineText = headlineTextContent,
            supportingText = supportingTextContent,
            leadingContent = leadingContent,
            trailingContent = trailingContent,
        )

        if (hasDivider) {
            Divider(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 24.dp,
                )
            )
        }

        if (bottomContent != null) {
            bottomContent()
        }
    }
}


@Preview
@Composable
private fun BaseListItemPreview() {
    BaseListItemInternal(
        headlineText = "Ciao",
        supportingText = "Come",
        trailingIcon = ImageData.IconImageData(
            Icons.Filled.KeyboardArrowRight,
            R.string.expand_content.uiText,
        ),
        hasDivider = true,
        trailingText = "",
        leadingAvatarText = "",
        leadingIcon = null,
        onClick = null,
        bottomContent = null,
    )
}

@Preview
@Composable
private fun BaseListItemLeadingIconPreview() {
    BaseListItemInternal(
        headlineText = "Ciao",
        supportingText = "Come",
        leadingIcon = ImageData.IconImageData(
            Icons.Filled.KeyboardArrowRight,
            R.string.expand_content.uiText,
        ),
        hasDivider = true,
        trailingText = "",
        trailingIcon = null,
        leadingAvatarText = "",
        onClick = null,
        bottomContent = null,
    )
}

@Preview
@Composable
private fun BaseListItemLeadingAvatarPreview() {
    BaseListItemInternal(
        headlineText = "Ciao",
        supportingText = "Come",
        leadingAvatarText = "A",
        hasDivider = true,
        trailingText = "",
        trailingIcon = null,
        leadingIcon = null,
        onClick = null,
        bottomContent = null,
    )
}