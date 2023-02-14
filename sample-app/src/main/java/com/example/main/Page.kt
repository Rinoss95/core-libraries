package com.example.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.card.*
import com.example.main.components.SampleAppBar
import com.example.main.model.AppRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Page(
    appRoute: AppRoute,
    onMenuClick: () -> Unit,
    onSettingsClick: (() -> Unit)? = null,
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState),
    topAppBar: @Composable () -> Unit = {
        SampleAppBar(
            appRoute,
            onMenuClick = onMenuClick,
            onSettingsClick = onSettingsClick,
            scrollBehavior = scrollBehavior,
        )
    },
    content: @Composable (Modifier) -> Unit,
) {
    Scaffold(
        topBar = topAppBar,
    ) { innerPadding ->
        content(
            Modifier
                .padding(innerPadding)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
        )
    }
}