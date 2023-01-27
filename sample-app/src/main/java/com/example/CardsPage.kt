package com.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.text.HeadlineLarge
import com.rinoss95.core_ui.component.text.TitleLarge

@Composable
fun CardsPage() {
    TitleLarge(text = "Cards")

    Box(modifier = Modifier.padding(top = 24.dp))

    ElevatedCard {
        HeadlineLarge(
            "ElevatedCard",
            modifier = Modifier.padding(16.dp)
        )
    }

    Box(modifier = Modifier.padding(top = 24.dp))

    Card {
        HeadlineLarge(
            "FilledCard",
            modifier = Modifier.padding(16.dp)
        )
    }

    Box(modifier = Modifier.padding(top = 24.dp))

    OutlinedCard {
        HeadlineLarge(
            "OutlinedCard",
            modifier = Modifier.padding(16.dp)
        )
    }
}