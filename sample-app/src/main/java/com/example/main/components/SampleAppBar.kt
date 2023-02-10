package com.example.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.text.TitleLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppBar(
    currentRoute: AppRoute,
    onMenuClick: () -> Unit,
    onSettingsClick: (() -> Unit)? = null,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            TitleLarge(
                text = currentRoute.displayName,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onMenuClick,
            ) {
                Icon(
                    Icons.Filled.Menu,
                    "",
                )
            }
        },
        actions = {
            if (onSettingsClick != null) {
                IconButton(
                    onClick = onSettingsClick,
                ) {
                    Icon(
                        Icons.Filled.Settings,
                        "",
                    )
                }
            }
        }
    )
}