package com.rinoss95.core_ui.converter

import coil.compose.AsyncImagePainter
import com.rinoss95.core_ui.model.ImageData

fun AsyncImagePainter.State.toNetworkImageState(): ImageData.NetworkImage.State {
    return when (this) {
        AsyncImagePainter.State.Empty -> ImageData.NetworkImage.State.Empty
        is AsyncImagePainter.State.Error -> ImageData.NetworkImage.State.Error
        is AsyncImagePainter.State.Loading -> ImageData.NetworkImage.State.Loading
        is AsyncImagePainter.State.Success -> ImageData.NetworkImage.State.Success
    }
}