package com.rinoss95.core_ui.component.card

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rinoss95.core_ui.component.card.internal.ListItemCardsFilling

@Composable
fun ListItemCard(
    modifier: Modifier = Modifier,
    avatarText: String = "",
    headerTitle: String = "",
    headerSubtitle: String = "",
    trailingContent: (@Composable BoxScope.() -> Unit)? = null,
) {
    Card(modifier) {
        ListItemCardsFilling(
            avatarText,
            headerTitle,
            headerSubtitle,
            trailingContent,
        )
    }
}

