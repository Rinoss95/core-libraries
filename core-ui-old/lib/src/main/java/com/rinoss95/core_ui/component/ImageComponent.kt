package com.rinoss95.core_ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.rinoss95.core_ui.converter.toNetworkImageState
import com.rinoss95.core_ui.util.toStringOrEmpty

@Composable
fun ImageComponent(
    imageData: com.rinoss95.core_ui.model.ImageData,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    onState: (com.rinoss95.core_ui.model.ImageData.NetworkImage.State) -> Unit = {},
) {
    when (imageData) {
        is com.rinoss95.core_ui.model.ImageData.LocalImageData -> Image(
            modifier = modifier,
            contentScale = contentScale,
            painter = painterResource(imageData.imageRes),
            contentDescription = imageData.contentDescriptionRes.toStringOrEmpty(),
        )

        is com.rinoss95.core_ui.model.ImageData.NetworkImage -> AsyncImage(
            modifier = modifier,
            contentScale = contentScale,
            model = imageData.imageUrl,
            contentDescription = imageData.contentDescriptionRes.toStringOrEmpty(),
            onState = {
                onState(
                    it.toNetworkImageState()
                )
            }
        )

        is com.rinoss95.core_ui.model.ImageData.IconImageData -> Icon(
            imageData.imageVector,
            imageData.contentDescriptionRes.toStringOrEmpty()
        )
    }
}