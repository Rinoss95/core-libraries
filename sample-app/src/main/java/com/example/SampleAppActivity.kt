package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.theme.MyApplicationTheme
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.model.ImageData

class SampleAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                BaseListItemPage()
            }
        }
    }
}

@Composable
fun ExampleItem(
    modifier: Modifier = Modifier,
) {
    BaseListItem(
        modifier = modifier,
        headlineText = "Headline Text",
        supportingText = "Supporting Text",
        trailingIcon = ImageData.IconImageData(
            Icons.Filled.KeyboardArrowRight,
            null,
        ),
        hasDivider = true,
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun BaseListItemPage() {
    Column {
        ExampleItem()
    }
}