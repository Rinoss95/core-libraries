package com.example.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val margin: Margin = Margin(),
    val text: TextSpacing = TextSpacing(),
    val listItem: ListItem = ListItem(),
    val padding: Padding = Padding(),
    val cardElevation: Dp = 4.dp,
) {
    data class Padding(
        val small: Dp = 8.dp,
        val medium: Dp = 8.dp,
    )

    data class Margin(
        val horizontalPage: Dp = 16.dp,
        val small: Dp = 8.dp,
        val medium: Dp = 16.dp,
    )

    data class TextSpacing(
        val titleBottom: Dp = 8.dp,
        val subtitleBottom: Dp = 4.dp,
    )

    data class ListItem(
        val paddingVertical: Dp = 10.dp,
        val paddingStart: Dp = 16.dp,
        val paddingEnd: Dp = 8.dp,
        val dividerHorizontalPadding: Dp = 14.dp,
    )
}

val LocalSpacing = compositionLocalOf {
    Dimensions()
}