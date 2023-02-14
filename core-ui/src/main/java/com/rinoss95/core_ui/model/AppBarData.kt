package com.rinoss95.core_ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.util.uiText

data class AppBarModel(
    val state: SearchState = SearchState(),
    val data: AppBarData = AppBarData(),
)

data class SearchState(
    val isSearching: Boolean = false,
    val query: String = "",
)

data class AppBarData(
    val title: UiText = UiText.Plain(),
    val navigationIcon: Navigation? = null,
    val actions: List<Action> = listOf(),
) {
    sealed class Action(
        val icon: ImageData,
    ) {
        class Search(
            val onSearchEnter: () -> Unit,
        ) : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Search,
                contentDescription = R.string.search.uiText,
            ),
        )

        class Home(
            val onNavigateToHome: () -> Unit,
        ) : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Home,
                contentDescription = R.string.home.uiText,
            ),
        )
    }

    sealed class Navigation(
        val icon: ImageData,
    ) {
        class GoBack(
            val onGoBack: () -> Unit,
        ) : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = R.string.back_icon.uiText,
            ),
        )

        class Drawer(
            val onOpenDrawer: () -> Unit,
        ) : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Menu,
                contentDescription = R.string.menu.uiText,
            ),
        )
    }
}
