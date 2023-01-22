package com.rinoss95.core_ui.component

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rinoss95.core_ui.theme.dividerColor

@Composable
fun BaseDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        modifier = modifier,
        color = dividerColor
    )
}