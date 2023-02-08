package com.rinoss95.core_ui.component.list

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.rinoss95.core_ui.R

@Composable
fun ExpandableListItem2(
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)? = null,
    headlineText: String = "",
    supportingText: String = "",
    hasDivider: Boolean = false,
    isExpanded: Boolean = false,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        BaseListItem2(
            headlineText = headlineText,
            supportingText = supportingText,
            leading = leading,
            trailing = if (!isExpanded) {
                @Composable {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = stringResource(R.string.expand_content),
                    )
                }
            } else {
                @Composable {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = stringResource(R.string.collapse_content),
                    )
                }
            },
            hasDivider = hasDivider,
        )

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
fun ExpandableListItem2Preview() {
    ExpandableListItem2(
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