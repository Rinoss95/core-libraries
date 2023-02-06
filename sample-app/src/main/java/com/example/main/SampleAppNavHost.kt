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
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.ListPage.id,
    ) {
        composable(route = AppRoute.ListPage.id) {
            ListItemsPage()
        }

        composable(route = AppRoute.CardsPage.id) {
            CardsPage()
        }

        composable(route = AppRoute.SettingsPage.id) {
            SettingsPage(
                isDarkMode,
                onDarkModeChange,
            )
        }
    }
}