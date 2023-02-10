package com.example.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.card.CardsPage
import com.example.list.ListItemsPage
import com.example.main.model.AppRoute
import com.example.settings.SettingsPage

@Composable
fun SampleAppNavHost(
    navController: NavHostController,
    isDarkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    onMenuClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.ListPage.id,
    ) {
        composable(route = AppRoute.ListPage.id) {
            ListItemsPage(
                onMenuClick = onMenuClick,
                onSettingsClick = onSettingsClick,
            )
        }

        composable(route = AppRoute.CardsPage.id) {
            CardsPage(
                onMenuClick = onMenuClick,
                onSettingsClick = onSettingsClick,
            )
        }

        composable(route = AppRoute.SettingsPage.id) {
            SettingsPage(
                isDarkMode = isDarkMode,
                onDarkModeChange = onDarkModeChange,
                onMenuClick = onMenuClick,
            )
        }
    }
}