package com.example.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.card.CardsPage
import com.example.list.ListItemsPage
import com.example.main.model.SampleRoute

@Composable
fun SampleNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SampleRoute.ListPage.id,
    ) {
        composable(route = SampleRoute.ListPage.id) {
            ListItemsPage()
        }

        composable(route = SampleRoute.CardsPage.id) {
            CardsPage()
        }
    }
}