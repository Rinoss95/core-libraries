package com.rinoss95.core_ui.component.list

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.list.internal.BaseListItemInternal
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText

@Composable
fun ExpandableListItem(
    modifier: Modifier = Modifier,
    headlineText: String = "",
    supportingText: String = "",
    leadingAvatarText: String = "",
    leadingIcon: ImageData? = null,
    hasDivider: Boolean = false,
    onClick: (() -> Unit)? = null,
    isExpanded: Boolean = false,
    content: @Composable () -> Unit,
) {
    val trailingIcon = if (!isExpanded)
        ImageData.IconImageData(
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = R.string.expand_content.uiText,
        )
    else
        ImageData.IconImageData(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = R.string.collapse_content.uiText,
        )

    BaseListItemInternal(
        modifier = modifier,
        headlineText = headlineText,
        supportingText = supportingText,
        trailingText = "",
        trailingIcon = trailingIcon,
        leadingAvatarText = leadingAvatarText,
        leadingIcon = leadingIcon,
        hasDivider = hasDivider,
        onClick = onClick,
    ) {
        BottomContent(
            isExpanded = isExpanded,
            content = content,
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun BottomContent(
    isExpanded: Boolean,
    content: @Composable () -> Unit,
) {
    AnimatedContent(
        targetState = isExpanded,
        transitionSpec = {
            fadeIn(animationSpec = tween(150, 150)) with
                    fadeOut(animationSpec = tween(150)) using
                    SizeTransform { initialSize, targetSize ->
                        if (targetState) {
                            keyframes {
                                // Expand horizontally first.
                                IntSize(targetSize.width, initialSize.height) at 150
                                durationMillis = 300
                            }
                        } else {
                            keyframes {
                                // Shrink vertically first.
                                IntSize(initialSize.width, targetSize.height) at 150
                                durationMillis = 300
                            }
                        }
                    }
        },
    ) { targetExpanded ->
        if (targetExpanded) {
            content()
        }
    }
}


@Preview
@Composable
fun ExpandableListItemPreview() {
    ExpandableListItem(
        isExpanded = true,
        headlineText = "Ciao",
        supportingText = "Come",
        hasDivider = true,
    ) {
        Column {
            for (i in 1..3) {
                BaseListItem(
                    headlineText = "Item $i"
                )
            }
        }
    }
}