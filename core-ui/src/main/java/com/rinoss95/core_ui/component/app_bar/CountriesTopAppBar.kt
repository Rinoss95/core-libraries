package com.rinoss95.core_ui.component.app_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.model.AppBarData
import com.rinoss95.core_ui.model.AppBarState
import com.rinoss95.core_ui.util.uiText
import com.rinoss95.core_ui.util.value

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CountriesTopAppBar(
    data: AppBarData?,
    state: AppBarState,
    onGoBack: () -> Unit = {},
    onGoHome: () -> Unit = {},
    onOpenDrawer: () -> Unit = {},
    onSearchEnter: () -> Unit = {},
    onQueryChange: (String) -> Unit = {},
    onSearchExit: () -> Unit = {},
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    var showClearButton by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
            when {
                state.isSearching -> {
                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { focusState ->
                                showClearButton = (focusState.isFocused)
                            }
                            .focusRequester(focusRequester),
                        value = state.query,
                        textStyle = MaterialTheme.typography.bodyLarge,
                        onValueChange = onQueryChange,
                        maxLines = 1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        ),
                    )
                }

                else -> {
                    data?.title?.let { title ->
                        TitleLarge(title.value())
                    }
                }
            }
        },
        navigationIcon = {
            when {
                state.isSearching -> {
                    IconButton(
                        onClick = onSearchExit
                    ) {
                        ImageComponent(
                            imageData = com.rinoss95.core_ui.model.ImageData.IconImageData(
                                Icons.Filled.ArrowBack,
                                R.string.exit_search.uiText,
                            ),
                        )
                    }
                }

                else -> {
                    data?.navigationIcon?.let { navigation ->
                        IconButton(
                            onClick = when (navigation) {
                                is AppBarData.Navigation.Drawer -> onOpenDrawer

                                is AppBarData.Navigation.GoBack -> onGoBack
                            }
                        ) {
                            ImageComponent(imageData = navigation.icon)
                        }
                    }
                }
            }
        },
        actions = {
            when {
                state.isSearching -> {
                    AnimatedVisibility(
                        enter = fadeIn(),
                        exit = fadeOut(),
                        visible = showClearButton,
                    ) {
                        IconButton(
                            onClick = {
                                onQueryChange("")
                            }
                        ) {
                            ImageComponent(
                                imageData = com.rinoss95.core_ui.model.ImageData.IconImageData(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = R.string.remove_search.uiText,
                                ),
                            )
                        }
                    }
                }

                else -> {
                    data?.actions?.forEach { action ->
                        IconButton(
                            onClick = when (action) {
                                is AppBarData.Action.Search -> onSearchEnter

                                is AppBarData.Action.Home -> onGoHome
                            }
                        ) {
                            ImageComponent(imageData = action.icon)
                        }
                    }
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )

    if (state.isSearching) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountriesTopAppBarPreview() {
    CountriesTopAppBar(
        data = AppBarData(
            "All Countries".uiText,
            AppBarData.Navigation.Drawer(),
            listOf(
                AppBarData.Action.Search()
            ),
        ),
        state = AppBarState(),
    )
}

@Preview(showBackground = true)
@Composable
private fun CountriesTopAppBarSearchPreview() {
    CountriesTopAppBar(
        data = AppBarData(
            "All Countries".uiText,
            AppBarData.Navigation.Drawer(),
            listOf(
                AppBarData.Action.Search()
            ),
        ),
        state = AppBarState(
            isSearching = true,
            query = "Sto cercando..."
        ),
    )
}