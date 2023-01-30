package com.rinoss95.core_ui.component.miscellaneus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.text.TitleMedium

@Composable
fun TextAvatar(
    avatarText: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    avatarSize: Dp = 40.dp,
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(avatarSize)
                .clip(CircleShape)
                .background(color = backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            TitleMedium(
                text = avatarText,
                color = textColor,
            )
        }
    }
}

@Preview
@Composable
private fun AvatarPreview() {
    TextAvatar(
        "A",
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.onSurfaceVariant,
    )
}