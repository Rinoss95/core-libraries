package com.example.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.main.model.SampleRoute
import com.rinoss95.core_ui.component.text.HeadlineMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppBar(
    currentRoute: SampleRoute,
    onMenuClick: () -> Unit,
) {
    TopAppBar(
        title = {
            HeadlineMedium(
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
        }
    )
}