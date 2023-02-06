package com.example.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.component.list.BaseListItem2
import com.rinoss95.core_ui.component.list.ExpandableListItem
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.sample.R
import com.rinoss95.core_ui.util.uiText

@Composable
fun ListItemsPage() {
    LazyColumn {
        item {
            Column(
                Modifier.padding(bottom = 16.dp),
            ) {
                BaseListItemPreview()

                BaseListItem2Preview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaseListItemPreview() {
    TitleLarge(text = "BaseListItem")

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

@Preview(showBackground = true)
@Composable
fun BaseListItem2Preview() {
    val iconPerson = @Composable {
        Icon(
            Icons.Filled.Person,
            contentDescription = "",
        )
    }

    val iconArrowRight = @Composable {
        Icon(
            Icons.Filled.KeyboardArrowRight,
            contentDescription = "",
        )
    }

    Column {
        TitleLarge(
            text = "BaseListItem2",
            Modifier.padding(top = 24.dp, bottom = 8.dp),
        )

        BaseListItem2(
            headlineText = "Headline text",
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Long headline text that cannot stay on one line",
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            leading = iconPerson,
            headlineText = "Long headline text that cannot stay on one line",
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            leading = iconPerson,
            trailing = iconArrowRight,
            headlineText = "Long headline text that cannot stay on one line",
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            supportingText = "Supporting text",
            leading = iconPerson,
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            supportingText = "Very long Supporting text that cannot stay on one line",
            leading = iconPerson,
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            supportingText = "Very long Supporting text that cannot stay on one line",
            leading = iconPerson,
            trailing = iconArrowRight,
        )
    }
}
