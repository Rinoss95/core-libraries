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
import com.example.main.model.SampleRoute
import com.example.main.theme.MyApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SampleAppUI(
    viewModel: SampleViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()

    var currentRoute by remember {
        mutableStateOf(SampleRoute.ListPage)
    }

    val uiScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    MyApplicationTheme(
        darkTheme = viewModel.isDarkMode,
    ) {
        SampleDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            navController = navController,
            uiScope = uiScope,
            currentRoute = currentRoute,
            onClick = { newRoute ->
                currentRoute = newRoute
            },
        ) {
            Scaffold(
                topBar = {
                    SampleAppBar(currentRoute) {
                        uiScope.launch {
                            drawerState.open()
                        }
                    }
                }
            ) { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 16.dp)
                ) {
                    SampleNavHost(navController)
                }
            }
        }
    }
}