package com.example.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.main.components.SampleAppBar
import com.example.main.components.SampleAppDrawer
import com.example.main.model.AppRoute
import com.example.main.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SampleAppUI(
    appViewModel: SampleAppViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()

    var currentRoute by remember {
        mutableStateOf(AppRoute.ListPage)
    }

    val uiScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    MyApplicationTheme(
        darkTheme = appViewModel.isDarkMode,
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
            Scaffold(
                topBar = {
                    SampleAppBar(
                        currentRoute,
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
            ) { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 16.dp)
                ) {
                    SampleAppNavHost(
                        navController,
                        isDarkMode = appViewModel.isDarkMode,
                        onDarkModeChange = {
                            appViewModel.isDarkMode = it
                        }
                    )
                }
            }
        }
    }
}