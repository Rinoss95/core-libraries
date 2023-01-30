package com.example.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.main.model.SampleRoute
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.sample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleDrawer(
    drawerState: DrawerState,
    navController: NavController,
    uiScope: CoroutineScope,
    currentRoute: SampleRoute,
    onClick: (SampleRoute) -> Unit,
    gesturesEnabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
        drawerContent = {
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
                            uiScope.launch {
                                drawerState.close()
                            }

                            onClick(route)

                            navController.navigate(route = route.id) {
                                popUpTo(0)
                            }
                        }
                    )
                }
            }
        },
        content = content,
    )
}