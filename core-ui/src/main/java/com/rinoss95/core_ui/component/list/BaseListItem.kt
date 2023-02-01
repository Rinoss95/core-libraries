package com.rinoss95.core_ui.component.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.list.internal.BaseListItemInternal
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText

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
) = BaseListItemInternal(
    modifier = modifier,
    headlineText = headlineText,
    supportingText = supportingText,
    trailingText = trailingText,
    trailingIcon = trailingIcon,
    leadingAvatarText = leadingAvatarText,
    leadingIcon = leadingIcon,
    hasDivider = hasDivider,
    onClick = onClick,
    bottomContent = null,
)


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