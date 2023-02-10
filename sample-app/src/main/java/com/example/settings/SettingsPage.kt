package com.example.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.main.Page
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.text.TitleMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(
    isDarkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    onMenuClick: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    Page(
        appRoute = AppRoute.SettingsPage,
        onMenuClick = onMenuClick,
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
            item {
                ListItem(
                    headlineText = {
                        TitleMedium(text = "Dark Mode")
                    },
                    trailingContent = {
                        Switch(
                            checked = isDarkMode,
                            onCheckedChange = onDarkModeChange,
                        )
                    }
                )
            }
        }
    }
}
