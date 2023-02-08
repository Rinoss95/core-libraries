package com.example.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.list.BaseListItem
import com.rinoss95.core_ui.component.list.BaseListItem2
import com.rinoss95.core_ui.component.list.ExpandableListItem
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
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

                BaseListItem2Preview1()

                BaseListItem2Preview2()

                BaseListItem2Preview3()
            }
        }
    }
}

private val iconPerson = @Composable {
    Icon(
        Icons.Outlined.Person,
        contentDescription = "",
    )
}

private val iconArrowRight = @Composable {
    Icon(
        Icons.Filled.KeyboardArrowRight,
        contentDescription = "",
    )
}

private val avatar = @Composable {
    TextAvatar(
        avatarText = "A",
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        textColor = MaterialTheme.colorScheme.onPrimaryContainer,
    )
}

private val thumbnailSmall = @Composable {
    Image(
        painterResource(id = R.drawable.thumbnail_small),
        contentDescription = ""
    )
}

private val thumbnailBig = @Composable {
    Image(
        painterResource(id = R.drawable.thumbnail_big),
        contentDescription = ""
    )
}

@OptIn(ExperimentalMaterial3Api::class)
private val checkbox = @Composable {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Checkbox(
            checked = true,
            onCheckedChange = {},
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private val radio = @Composable {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        RadioButton(
            selected = true,
            onClick = {},
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private val switch = @Composable {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        Switch(
            checked = true,
            onCheckedChange = {},
        )
    }
}

private val leadings = listOf(
    avatar,
    iconPerson,
    thumbnailSmall,
    thumbnailBig,
    checkbox,
    radio,
    switch,
)

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
fun BaseListItem2Preview1() {
    Column {
        TitleLarge(
            text = "BaseListItem2",
            Modifier.padding(top = 24.dp, bottom = 8.dp),
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
fun BaseListItem2Preview2() {
    Column {
        for (leading in leadings) {
            Set(
                leading = leading,
                trailing = iconArrowRight,
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
fun BaseListItem2Preview3() {
    Column {
        for (leading in leadings) {
            Set(
                leading = leading,
                trailing = checkbox,
            )
        }
    }
}

@Composable
fun Set(
    leading: @Composable () -> Unit,
    trailing: @Composable () -> Unit,
) {
    Column {
        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            leading = leading,
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            leading = leading,
            trailing = trailing,
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            supportingText = "Supporting text",
            leading = leading,
            trailing = trailing,
        )

        BaseListItem2(
            Modifier
                .padding(top = 8.dp)
                .clickable(onClick = {}),
            headlineText = "Headline text",
            supportingText = "Very long supporting text that cannot stay on one line",
            leading = leading,
            trailing = trailing,
        )
    }
}
