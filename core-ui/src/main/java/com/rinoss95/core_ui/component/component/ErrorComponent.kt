package com.rinoss95.core_ui.component.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.model.ErrorData
import com.rinoss95.core_ui.util.value

@Composable
fun ErrorComponent(
    modifier: Modifier = Modifier,
    error: ErrorData,
    onRetryClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            error.errorImage?.let {
                ImageComponent(imageData = it)
            }

            if (error.title.value().isNotBlank()) {
                Text(
                    text = error.title.value(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            if (error.message.value().isNotBlank()) {
                Text(
                    text = error.message.value(),
                    modifier = Modifier.padding(top = 16.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }

        if (error.cta.value().isNotBlank()) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onRetryClick,
            ) {
                Text(text = error.cta.value())
            }
        }
    }
}