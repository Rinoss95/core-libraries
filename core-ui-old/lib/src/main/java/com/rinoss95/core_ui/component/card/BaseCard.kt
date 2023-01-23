package com.rinoss95.core_ui.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.theme.LocalSpacing
import com.rinoss95.core_ui.theme.dividerColor

@Composable
fun BaseCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val elevation = LocalSpacing.current.cardElevation

    Card(
        modifier = modifier.padding(elevation),
        elevation = CardDefaults.cardElevation(elevation),
        border = BorderStroke(1.dp, dividerColor),
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun BaseCardPreview() {
    BaseCard {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Ciao")
        }
    }
}