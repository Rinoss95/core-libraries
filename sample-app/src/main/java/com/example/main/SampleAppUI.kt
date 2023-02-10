package com.example.main

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.main.components.SampleAppDrawer
import com.example.main.model.AppRoute
import com.example.main.theme.SampleAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SampleAppUI(
    viewModel: SampleAppViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()

    var currentRoute by remember {
        mutableStateOf(AppRoute.ListPage)
    }

    val uiScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    SampleAppTheme(
        darkTheme = viewModel.isDarkMode,
    ) {
        SampleAppDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            uiScope = uiScope,
            currentRoute = currentRoute,
            onClick = { newRoute ->
                currentRoute = newRoute

                navController.navigate(route = newRoute.id) {
                    popUpTo(0)
                }
            },
        ) {
            SampleAppNavHost(
                navController = navController,
                isDarkMode = viewModel.isDarkMode,
                onDarkModeChange = {
                    viewModel.isDarkMode = it
                },
                onMenuClick = {
                    uiScope.launch {
                        drawerState.open()
                    }
                },
                onSettingsClick = {
                    currentRoute = AppRoute.SettingsPage

                    navController.navigate(AppRoute.SettingsPage.id)
                }
            )
        }
    }
}