package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theme.MyApplicationTheme
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.component.list.ExpandableListItem
import com.rinoss95.core_ui.component.text.HeadlineLarge
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText

class SampleAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                SamplePage()
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
            "".uiText,
        ),
        hasDivider = true,
    ) {

    }
}

@Composable
@Preview(showBackground = true)
private fun SamplePage() {
    Column(
        Modifier.padding(horizontal = 16.dp),
    ) {
        ExampleItem()

        var isExpanded by remember {
            mutableStateOf(false)
        }

        ExpandableListItem(
            headlineText = "Headline Text",
            supportingText = "Supporting Text",
            hasDivider = true,
            isExpanded = isExpanded,
            onClick = {
                isExpanded = !isExpanded
            }) {
            Column {
                ExampleItem()
                ExampleItem()
                ExampleItem()
            }
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        ElevatedCard {
            HeadlineLarge(
                "ElevatedCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        Card {
            HeadlineLarge(
                "FilledCard",
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(modifier = Modifier.padding(top = 24.dp))

        OutlinedCard {
            HeadlineLarge(
                "OutlinedCard",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}