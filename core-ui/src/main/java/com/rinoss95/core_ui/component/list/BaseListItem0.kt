package com.rinoss95.core_ui.component.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rinoss95.core_ui.component.BaseDivider
import com.rinoss95.core_ui.component.text.BodyMedium
import com.rinoss95.core_ui.component.text.TitleMedium
import com.rinoss95.core_ui.theme.LocalSpacing

@Composable
fun BaseListItem0(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    headLineText: String = "",
    supportingText: String = "",
    hasDivider: Boolean = true,
    icon: @Composable () -> Unit = {},
) {
    val listItemSpacing = LocalSpacing.current.listItem

    Row(
        modifier = modifier.apply {
            onClick?.let {
                clickable(onClick = it)
            }
        },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = listItemSpacing.paddingVertical)
                .padding(start = listItemSpacing.paddingStart)
        ) {
            if (headLineText.isNotBlank()) {
                TitleMedium(headLineText)
            }

            if (supportingText.isNotBlank()) {
                Row {
                    BodyMedium(supportingText)
                }
            }
        }

        Box(
            modifier = Modifier.padding(end = listItemSpacing.paddingEnd)
        ) {
            icon()
        }
    }

    if (hasDivider) {
        BaseDivider(
            modifier = Modifier.padding(
                horizontal = listItemSpacing.dividerHorizontalPadding
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BaseListItem0Preview() {
    BaseListItem0(
        headLineText = "Brasile",
        supportingText = "Name"
    ) {
        Icon(
            Icons.Filled.KeyboardArrowRight,
            ""
        )
    }
}