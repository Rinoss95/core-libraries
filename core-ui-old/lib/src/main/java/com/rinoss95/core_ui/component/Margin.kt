package com.rinoss95.core_ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalMargin(
    modifier: Modifier = Modifier,
    height: Dp
) {
    Spacer(
        modifier = modifier.height(
            height = height
        )
    )
}

