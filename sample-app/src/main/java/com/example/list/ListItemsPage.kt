package com.example.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.component.list.ExpandableListItem
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.sample.R
import com.rinoss95.core_ui.util.uiText

@Preview(showBackground = true)
@Composable
fun ListItemsPage() {
    LazyColumn {
        item {
            Column(
                Modifier.padding(bottom = 16.dp),
            ) {
                TitleLarge(text = "List Items")

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
                    mutableStateOf(true)
                }

                ExpandableListItem(
                    headlineText = "Headline Text",
                    supportingText = "Supporting Text",
                    hasDivider = isExpanded,
                    isExpanded = isExpanded,
                    onClick = {
                        isExpanded = !isExpanded
                    }) {
                    Column {
                        val length = 3
                        for (i in 1 until length) {
                            BaseListItem(
                                headlineText = "Headline Text",
                                supportingText = "Supporting Text",
                                hasDivider = i == length - 1,
                            )
                        }
                    }
                }
            }
        }
    }
}