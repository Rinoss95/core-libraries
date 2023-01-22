package com.rinoss95.core_ui.component.transitions

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset

object ExitTransitions {
    val SlideOut = slideOut(
        animationSpec = tween(durationMillis = 500)
    ) { size ->
        IntOffset(size.width / 2, 0)
    }

    val FadeOut = fadeOut(
        animationSpec = tween(durationMillis = 500),
    )

    val None = slideOut(
        animationSpec = tween(durationMillis = 0)
    ) {
        IntOffset.Zero
    }
}