package com.rinoss95.core_ui.component.card

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rinoss95.core_ui.component.card.internal.ListItemCardsFilling

@Composable
fun OutlinedListItemCard(
    modifier: Modifier = Modifier,
    avatarText: String = "",
    headerTitle: String = "",
    headerSubtitle: String = "",
    trailingContent: (@Composable BoxScope.() -> Unit)? = null,
) {
    OutlinedCard(modifier) {
        ListItemCardsFilling(
            avatarText,
            headerTitle,
            headerSubtitle,
            trailingContent,
        )
    }
}

