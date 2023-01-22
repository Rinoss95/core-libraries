package com.rinoss95.core_ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rinoss95.core_ui.component.card.BaseCard
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.lib.R

@Composable
fun ExpandableSection(
    title: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    isExpanded: Boolean = true,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier.animateContentSize(
            animationSpec = tween(durationMillis = 200)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TitleLarge(
                title,
                modifier = Modifier.weight(1f),
            )

            if (onClick != null) {
                IconButton(
                    onClick = onClick
                ) {
                    Icon(
                        if (isExpanded) {
                            Icons.Filled.KeyboardArrowUp
                        } else {
                            Icons.Filled.KeyboardArrowDown
                        },
                        stringResource(R.string.expand_content)
                    )
                }
            }
        }

        when (isExpanded) {
            true -> content()

            false -> BaseDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainSectionPreview() {
    ExpandableSection(
        "Languages",
        onClick = {},
    ) {
        BaseCard {
            listOf(
                "Italian",
                "Spanish",
                "French",
            )
        }
    }
}