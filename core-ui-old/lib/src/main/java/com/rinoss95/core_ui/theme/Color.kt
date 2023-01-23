package com.rinoss95.core_ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val dividerColor: Color
    @Composable get() = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
