package com.rinoss95.core_ui.component.transitions

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.ui.unit.IntOffset

object EnterTransitions {
    val SlideIn = slideIn(
        animationSpec = tween(durationMillis = 500)
    ) { size ->
        IntOffset(size.width / 2, 0)
    }

    val FadeIn = fadeIn(
        animationSpec = tween(durationMillis = 500),
    )

    val None = slideIn(
        animationSpec = tween(durationMillis = 0)
    ) {
        IntOffset.Zero
    }
}