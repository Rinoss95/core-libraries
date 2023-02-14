package com.example.app_bar_page

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.main.Page
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.app_bar.TopAppBar
import com.rinoss95.core_ui.model.AppBarData
import com.rinoss95.core_ui.model.SearchState
import com.rinoss95.core_ui.util.uiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarPage(
    onMenuClick: () -> Unit,
    onSettingsClick: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    var state by remember {
        mutableStateOf(SearchState())
    }

    val appBarData = AppBarData(
        title = "Search Page".uiText,
        navigationIcon = AppBarData.Navigation.Drawer(onMenuClick),
        actions = listOf(
            AppBarData.Action.Search(
                state = state,
                onSearchEnter = {
                    state = SearchState(isSearching = true)
                },
                onSearchExit = {
                    state = SearchState(isSearching = false)
                },
                onQueryChange = { query ->
                    state = state.copy(query = query)
                }
            )
        )
    )

    Page(
        appRoute = AppRoute.SettingsPage,
        onMenuClick = onMenuClick,
        onSettingsClick = onSettingsClick,
        topAppBar = {
            TopAppBar(data = appBarData)
        }
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
        }
    }
}