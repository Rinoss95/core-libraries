package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theme.MyApplicationTheme
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.component.list.ExpandableListItem
import com.rinoss95.core_ui.component.text.HeadlineLarge
import com.rinoss95.core_ui.component.text.TitleLarge
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
private fun SamplePage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TitleLarge(text = "Sample Page")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier.padding(
                top = padding.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp
            ),
        ) {
            item {
                Column {
                    Box(modifier = Modifier.padding(top = 24.dp))

                    BaseListItem(
                        headlineText = "Headline Text",
                        supportingText = "Supporting Text",
                        trailingIcon = ImageData.IconImageData(
                            Icons.Filled.KeyboardArrowRight,
                            R.string.expand_content.uiText,
                        ),
                        hasDivider = true,
                    )

                    Box(modifier = Modifier.padding(top = 24.dp))

                    BaseListItem(
                        headlineText = "Headline Text",
                        supportingText = "Supporting Text",
                        leadingIcon = ImageData.IconImageData(
                            Icons.Filled.KeyboardArrowRight,
                            R.string.expand_content.uiText,
                        ),
                        hasDivider = true,
                    )

                    Box(modifier = Modifier.padding(top = 24.dp))

                    BaseListItem(
                        headlineText = "Headline Text",
                        supportingText = "Supporting Text",
                        leadingAvatarText = "A",
                        hasDivider = true,
                    )

                    Box(modifier = Modifier.padding(top = 24.dp))

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
                            for (i in 1 until 3) {
                                BaseListItem(
                                    headlineText = "Headline Text",
                                    supportingText = "Supporting Text",
                                    hasDivider = true,
                                )
                            }
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
        }
    }
}