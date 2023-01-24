package com.rinoss95.core_ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.rinoss95.core_ui.converter.toNetworkImageState
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.toStringOrEmpty
import com.rinoss95.core_ui.util.value

@Composable
fun ImageComponent(
    imageData: ImageData,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onState: (ImageData.NetworkImage.State) -> Unit = {},
) {
    when (imageData) {
        is ImageData.LocalImageData -> Image(
            modifier = modifier,
            contentScale = contentScale,
            painter = painterResource(imageData.imageRes),
            contentDescription = imageData.contentDescription.value()
        )

        is ImageData.NetworkImage -> AsyncImage(
            modifier = modifier,
            contentScale = contentScale,
            model = imageData.imageUrl,
            contentDescription = imageData.contentDescription.value(),
            onState = {
                onState(
                    it.toNetworkImageState()
                )
            }
        )

        is ImageData.IconImageData -> Icon(
            imageData.imageVector,
            imageData.contentDescription.value()
        )
    }
}