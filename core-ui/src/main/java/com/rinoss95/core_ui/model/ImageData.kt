package com.rinoss95.core_ui.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ImageData(
    open val contentDescription: UiText,
) {
    data class LocalImageData(
        @DrawableRes val imageRes: Int,
        override val contentDescription: UiText,
    ) : ImageData(contentDescription)

    data class NetworkImage(
        val imageUrl: String,
        override val contentDescription: UiText,
    ) : ImageData(contentDescription){
        sealed class State {
            object Empty : State()
            object Loading : State()
            object Success : State()
            object Error : State()
        }
    }

    data class IconImageData(
        val imageVector: ImageVector,
        override val contentDescription: UiText,
    ) : ImageData(contentDescription)
}