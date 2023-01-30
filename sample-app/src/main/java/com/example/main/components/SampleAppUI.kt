package com.example.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.main.model.SampleRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun SampleAppUI() {
    val navController = rememberNavController()

    var currentRoute by remember {
        mutableStateOf(SampleRoute.ListPage)
    }

    val uiScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    SampleDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        navController = navController,
        uiScope = uiScope,
        currentRoute = currentRoute,
        onClick = { newRoute ->
            currentRoute = newRoute
        },
    ) {
        Scaffold(
            topBar = {
                SampleAppBar(currentRoute)
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