package com.example.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.main.Page
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.list.BaseListItem2
import com.rinoss95.core_ui.component.list.ExpandableListItem2
import com.rinoss95.core_ui.component.miscellaneus.TextAvatar
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.sample.R

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
            checked = false,
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

private val trailings = listOf(
    iconArrowRight,
    checkbox,
    checkbox,
    switch,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemsPage(
    onMenuClick: () -> Unit,
    onSettingsClick: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    var isExpanded by remember {
        mutableStateOf(true)
    }

    Page(
        appRoute = AppRoute.ListPage,
        onMenuClick = onMenuClick,
        onSettingsClick = onSettingsClick,
    ) {
        LazyColumn(
            modifier = it,
            state = lazyListState,
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp,
            ),
        ) {
            ExpandableList(isExpanded) {
                isExpanded = !isExpanded
            }

            ListItemPreviews()
        }
    }
}

fun LazyListScope.ExpandableList(isExpanded: Boolean, onClick: () -> Unit) {
    item {
        TitleLarge(
            text = "Expandable List",
            Modifier.padding(top = 24.dp),
        )
    }

    item {
        ExpandableListItem2(
            headlineText = "Headline Text",
            supportingText = "Supporting Text",
            hasDivider = isExpanded,
            isExpanded = isExpanded,
            onClick = onClick
        ) {
            Column {
                val length = 3
                for (i in 1 until length) {
                    BaseListItem2(
                        headlineText = "Headline Text",
                        supportingText = "Supporting Text",
                        hasDivider = i == length - 1,
                    )
                }
            }
        }
    }
}

private fun LazyListScope.ListItemPreviews() {
    item {
        TitleLarge(
            text = "List Items",
            Modifier.padding(top = 24.dp),
        )
    }

    for (trailing in trailings) {
        BaseListItem2Sets(trailing)
    }

    for (trailing in trailings) {
        BaseListItem2Sets(trailing, true)
    }
}

private fun LazyListScope.BaseListItem2Sets(
    trailing: @Composable () -> Unit,
    hasOverline: Boolean = false,
) {
    for (leading in leadings) {
        if (leading !== trailing) {
            item {
                BaseListItem2(
                    Modifier
                        .padding(top = 8.dp)
                        .clickable(onClick = {}),
                    overlineText = if (hasOverline) "Overline text" else "",
                    headlineText = "Headline text",
                    leading = leading,
                )
            }

            item {
                BaseListItem2(
                    Modifier
                        .padding(top = 8.dp)
                        .clickable(onClick = {}),
                    overlineText = if (hasOverline) "Overline text" else "",
                    headlineText = "Headline text",
                    leading = leading,
                    trailing = trailing,
                )
            }

            item {
                BaseListItem2(
                    Modifier
                        .padding(top = 8.dp)
                        .clickable(onClick = {}),
                    overlineText = if (hasOverline) "Overline text" else "",
                    headlineText = "Headline text",
                    supportingText = "Supporting text",
                    leading = leading,
                    trailing = trailing,
                )
            }

            item {
                BaseListItem2(
                    Modifier
                        .padding(top = 8.dp)
                        .clickable(onClick = {}),
                    overlineText = if (hasOverline) "Overline text" else "",
                    headlineText = "Headline text",
                    supportingText = "Very long supporting text that cannot stay on one line",
                    leading = leading,
                    trailing = trailing,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets1() = LazyColumn {
    BaseListItem2Sets(trailings[0])
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets2() = LazyColumn {
    BaseListItem2Sets(trailings[1])
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets3() = LazyColumn {
    BaseListItem2Sets(trailings[2])
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets4() = LazyColumn {
    BaseListItem2Sets(trailings[3])
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets5() = LazyColumn {
    BaseListItem2Sets(trailings[0], true)
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets6() = LazyColumn {
    BaseListItem2Sets(trailings[1], true)
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets7() = LazyColumn {
    BaseListItem2Sets(trailings[2], true)
}

@Preview(
    showBackground = true,
    heightDp = 2000,
)
@Composable
private fun BaseListItem2Sets8() = LazyColumn {
    BaseListItem2Sets(trailings[3], true)
}
