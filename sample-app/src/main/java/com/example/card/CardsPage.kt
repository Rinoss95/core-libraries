package com.example.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.main.Page
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.card.*
import com.rinoss95.core_ui.component.text.HeadlineLarge
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.sample.R
import com.rinoss95.core_ui.util.uiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CardsPage(
    onMenuClick: () -> Unit,
    onSettingsClick: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
) {

    Page(
        appRoute = AppRoute.CardsPage,
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
            item { TitleLarge(text = "Cards") }

            item { Box(modifier = Modifier.padding(top = 24.dp)) }

            item {
                ElevatedCard {
                    HeadlineLarge(
                        "ElevatedCard",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            item { Box(modifier = Modifier.padding(top = 24.dp)) }

            item {
                Card {
                    HeadlineLarge(
                        "FilledCard",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            item { Box(modifier = Modifier.padding(top = 24.dp)) }

            item {
                OutlinedCard {
                    HeadlineLarge(
                        "OutlinedCard",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            item { ContentCardExample() }

            item { ElevatedContentCardExample() }

            item { OutlinedContentCardExample() }

            item { TwoContentCardsInARow() }

            item { ContentCardWithImage() }

            item { ListItemCardExample() }

            item { ElevatedListItemCardExample() }

            item { OutlinedListItemCardExample() }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentCardExample() {
    Column {
        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "ContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        ContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ElevatedContentCardExample() {
    Column {
        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "ElevatedContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        ElevatedContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedContentCardExample() {
    Column {
        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "OutlinedContentCard")

        Box(modifier = Modifier.padding(top = 24.dp))

        OutlinedContentCard(
            headerTitle = "Header",
            headerSubtitle = "Subhead",
            headerAvatarText = "A",
            onIconClick = {},
            iconContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    "",
                )
            },
            imageContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(188.dp)
                        .background(color = Color.Red),
                )
            },
            bodyTextTitle = "Title",
            bodyTextSubtitle = "Subhead",
            bodyTextContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            primaryButtonText = "Primary",
            secondaryButtonText = "Secondary",
            onPrimaryButtonClick = { },
            onSecondaryButtonClick = { },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TwoContentCardsInARow() {
    Column {
        Box(modifier = Modifier.padding(top = 24.dp))

        TitleLarge(text = "Two ContentCard in a Row")

        Box(modifier = Modifier.padding(top = 24.dp))

        BoxWithConstraints {
            val horizontal = 16.dp

            val size = (maxWidth - horizontal) / 2

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ContentCard(
                    bodyTextTitle = "Card 1",
                    imageContent = {
                        Box(
                            modifier = Modifier
                                .size(size)
                                .background(color = Color.Blue),
                        )
                    }
                )

                ContentCard(
                    bodyTextTitle = "Card 2",
                    imageContent = {
                        Box(
                            modifier = Modifier
                                .size(size)
                                .background(color = Color.Green),
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentCardWithImage() {
    Box(modifier = Modifier.padding(top = 24.dp))

    TitleLarge(text = "ContentCard with image")

    Box(modifier = Modifier.padding(top = 24.dp))

    BoxWithConstraints {
        val maxWidth = this.maxWidth

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            ElevatedContentCard(
                bodyTextTitle = "ContentCard with image"
            ) {
                Box(
                    modifier = Modifier.size(maxWidth),
                ) {
                    ImageComponent(
                        imageData = ImageData.LocalImageData(
                            R.drawable.ic_launcher_foreground,
                            "".uiText,
                        ),
                        modifier = Modifier
                            .sizeIn(maxWidth)
                            .clip(
                                shape = MaterialTheme.shapes.medium
                            )
                            .align(
                                Alignment.Center,
                            ),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemCardExample() {
    Box(modifier = Modifier.padding(top = 24.dp))

    TitleLarge(text = "ListItemCard")

    Box(modifier = Modifier.padding(top = 24.dp))

    ListItemCard(
        avatarText = "A",
        headerTitle = "Header",
        headerSubtitle = "Subtitle",
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Red)
                .width(520.dp)
                .heightIn(120.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ElevatedListItemCardExample() {
    Box(modifier = Modifier.padding(top = 24.dp))

    TitleLarge(text = "ElevatedListItemCard")

    Box(modifier = Modifier.padding(top = 24.dp))

    ElevatedListItemCard(
        avatarText = "A",
        headerTitle = "Header",
        headerSubtitle = "Subtitle",
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Red)
                .width(520.dp)
                .heightIn(120.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedListItemCardExample() {
    Box(modifier = Modifier.padding(top = 24.dp))

    TitleLarge(text = "OutlinedListItemCard")

    Box(modifier = Modifier.padding(top = 24.dp))

    OutlinedListItemCard(
        avatarText = "A",
        headerTitle = "Header",
        headerSubtitle = "Subtitle",
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.Red)
                .width(520.dp)
                .heightIn(120.dp),
        )
    }
}