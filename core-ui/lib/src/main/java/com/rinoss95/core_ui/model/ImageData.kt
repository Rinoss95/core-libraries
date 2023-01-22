package com.rinoss95.core_ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ImageData(
    @StringRes open val contentDescriptionRes: Int?,
) {
    data class LocalImageData(
        @DrawableRes val imageRes: Int,
        @StringRes override val contentDescriptionRes: Int?,
    ) : ImageData(contentDescriptionRes)

    data class NetworkImage(
        val imageUrl: String,
        @StringRes override val contentDescriptionRes: Int?,
    ) : ImageData(contentDescriptionRes){
        sealed class State {
            object Empty : State()
            object Loading : State()
            object Success : State()
            object Error : State()
        }
    }

    data class IconImageData(
        val imageVector: ImageVector,
        @StringRes override val contentDescriptionRes: Int?,
    ) : ImageData(contentDescriptionRes)
}