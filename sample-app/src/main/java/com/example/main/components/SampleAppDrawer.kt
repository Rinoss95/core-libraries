package com.example.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.main.model.AppRoute
import com.rinoss95.core_ui.component.text.TitleLarge
import com.rinoss95.core_ui.sample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppDrawer(
    drawerState: DrawerState,
    uiScope: CoroutineScope,
    currentRoute: AppRoute,
    onClick: (AppRoute) -> Unit,
    gesturesEnabled: Boolean = true,
    routes: List<AppRoute> = AppRoute.values().filter {
        it != AppRoute.SettingsPage
    },
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

                routes.forEach { route ->
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
                        }
                    )
                }
            }
        },
        content = content,
    )
}