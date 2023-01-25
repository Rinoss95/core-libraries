package com.rinoss95.core_ui.component.text

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HeadlineSmall(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall,
    )
}

@Composable
fun HeadlineMedium(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium,
    )
}

@Composable
fun HeadlineLarge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun TitleSmall(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.titleSmall,
    )
}

@Composable
fun TitleMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        color = color,
    )
}

@Composable
fun TitleLarge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun BodySmall(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun BodyMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
    )
}

@Composable
fun BodyLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
    )
}

@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.labelSmall,
        color = color,
    )
}

@Composable
fun LabelMedium(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
fun LabelLarge(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge,
    )
}

@Preview(showBackground = true)
@Composable
private fun TextPreview() {
    Column {
        HeadlineSmall("HeadlineSmall")
        HeadlineMedium("HeadlineMedium")
        HeadlineLarge("HeadlineLarge")
        TitleSmall("TitleSmall")
        TitleMedium("TitleMedium")
        TitleLarge("TitleLarge")
        BodySmall("BodySmall")
        BodyMedium("BodyMedium")
        BodyLarge("BodyLarge")
        LabelSmall("LabelSmall")
        LabelMedium("LabelMedium")
        LabelLarge("LabelLarge")
    }
}