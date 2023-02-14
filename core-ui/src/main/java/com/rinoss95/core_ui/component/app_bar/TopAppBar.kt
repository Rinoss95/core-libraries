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
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.component.ImageComponent
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.model.AppBarData
import com.rinoss95.core_ui.model.AppBarData.Action.Search.SearchState
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.util.uiText
import com.rinoss95.core_ui.util.value

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TopAppBar(data: AppBarData?) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    var showClearButton by remember { mutableStateOf(false) }

    val searchAction = data?.actions?.firstOrNull {
        it is AppBarData.Action.Search
    }?.let { searchAction ->
        (searchAction as AppBarData.Action.Search)
    }

    val state = searchAction?.state ?: SearchState()

    val onQueryChange = searchAction?.onQueryChange ?: { }
    val onSearchExit = searchAction?.onSearchExit ?: { }

    CenterAlignedTopAppBar(
        title = {
            when {
                state.isSearching -> {
                    SearchTextField(
                        onFocusChanged = { focusState ->
                            showClearButton = (focusState.isFocused)
                        },
                        focusRequester = focusRequester,
                        query = state.query,
                        onQueryChange = onQueryChange,
                        keyboardController = keyboardController,
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
                state.isSearching -> ExitSearchButton(onSearchExit)

                else -> data?.navigationIcon?.let { navigation ->
                    IconButton(
                        onClick = when (navigation) {
                            is AppBarData.Navigation.Drawer -> navigation.onOpenDrawer

                            is AppBarData.Navigation.GoBack -> navigation.onGoBack
                        }
                    ) {
                        ImageComponent(imageData = navigation.icon)
                    }
                }
            }
        },
        actions = {
            when {
                state.isSearching -> ClearButton(
                    showClearButton,
                    onQueryChange,
                )

                else -> data?.actions?.forEach { action ->
                    ActionButton(action)
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

@Composable
fun ExitSearchButton(onSearchExit: () -> Unit) {
    IconButton(
        onClick = onSearchExit
    ) {
        ImageComponent(
            imageData = ImageData.IconImageData(
                Icons.Filled.ArrowBack,
                R.string.exit_search.uiText,
            ),
        )
    }
}

@Composable
fun ActionButton(action: AppBarData.Action) {
    IconButton(
        onClick = when (action) {
            is AppBarData.Action.Home -> action.onNavigateToHome

            is AppBarData.Action.Search -> action.onSearchEnter
        }
    ) {
        ImageComponent(imageData = action.icon)
    }
}

@Composable
private fun ClearButton(
    showClearButton: Boolean,
    onQueryChange: (String) -> Unit,
) {
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
                imageData = ImageData.IconImageData(
                    imageVector = Icons.Filled.Close,
                    contentDescription = R.string.remove_search.uiText,
                ),
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SearchTextField(
    onFocusChanged: (FocusState) -> Unit,
    focusRequester: FocusRequester,
    query: String,
    onQueryChange: (String) -> Unit,
    keyboardController: SoftwareKeyboardController?,
) {
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged(onFocusChanged)
            .focusRequester(focusRequester),
        value = query,
        textStyle = MaterialTheme.typography.bodyLarge,
        onValueChange = {
            onQueryChange(it)
        },
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

@Preview(showBackground = true)
@Composable
private fun CountriesTopAppBarPreview() {
    TopAppBar(
        data = AppBarData(
            "All Countries".uiText,
            AppBarData.Navigation.Drawer({}),
            listOf(
                AppBarData.Action.Search(
                    SearchState(),
                    {},
                    {},
                    {},
                ),
            ),
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun CountriesTopAppBarSearchPreview() {
    TopAppBar(
        data = AppBarData(
            "All Countries".uiText,
            AppBarData.Navigation.Drawer({}),
            listOf(
                AppBarData.Action.Search(
                    SearchState(
                        isSearching = true,
                        query = "Sto cercando..."
                    ),
                    {},
                    {},
                    {},
                ),
            ),
        ),
    )
}