package com.rinoss95.core_ui.component.list

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.text.BodyLarge
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun ExpandableListItem(
    isExpanded: Boolean,
    modifier: Modifier = Modifier,
    headlineText: String = "",
    supportingText: String = "",
    hasDivider: Boolean = false,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
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

            trailingContent = {
                val iconImage = if (!isExpanded)
                    ImageData.IconImageData(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = R.string.expand_content.uiText,
                    )
                else
                    ImageData.IconImageData(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = R.string.collapse_content.uiText,
                    )

                ImageComponent(
                    modifier = Modifier.size(24.dp),
                    imageData = iconImage
                )
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

    }
}