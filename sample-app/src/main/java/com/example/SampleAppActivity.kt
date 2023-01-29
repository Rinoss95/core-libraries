package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.theme.MyApplicationTheme
import com.rinoss95.core_ui.component.text.HeadlineMedium
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.sample.R
import com.rinoss95.core_ui.util.value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SampleAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                SamplePage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
private fun SamplePage() {
    val navController = rememberNavController()

    var currentRoute by remember {
        mutableStateOf(SampleRoute.ListPage)
    }

    val uiScope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            SampleDrawer(
                drawerState = drawerState,
                navController = navController,
                uiScope = uiScope,
                currentRoute = currentRoute,
            ) { newRoute ->
                currentRoute = newRoute
            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppBar(currentRoute: SampleRoute) {
    TopAppBar(
        title = {
            HeadlineMedium(
                text = currentRoute.displayName,
            )
        }
    )
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleDrawer(
    drawerState: DrawerState,
    navController: NavHostController,
    uiScope: CoroutineScope,
    currentRoute: SampleRoute,
    onClick: (SampleRoute) -> Unit,
) {
    ModalDrawerSheet {
        TitleLarge(
            stringResource(id = R.string.app_name),
            modifier = Modifier.padding(
                start = 28.dp,
                top = 24.dp,
                bottom = 16.dp
            ),
        )

        SampleRoute.values().forEach { route ->
            NavigationDrawerItem(
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                selected = (route == currentRoute),
                label = {
                    Text(route.displayName)
                },
                onClick = {
                    onClick(route)

                    navController.navigate(route = route.id) {
                        popUpTo(0)
                    }

                    uiScope.launch {
                        drawerState.close()
                    }
                }
            )
        }
    }
}
