package com.rinoss95.core_ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import com.rinoss95.core_ui.R
import com.rinoss95.core_ui.util.uiText

data class AppBarModel(
    val state: AppBarState = AppBarState(),
    val data: AppBarData = AppBarData(),
)

data class AppBarState(
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
        class Search : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Search,
                contentDescription = R.string.search.uiText,
            )
        )

        class Home : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Home,
                contentDescription = R.string.home.uiText,
            )
        )
    }

    sealed class Navigation(
        val icon: ImageData,
    ) {
        class GoBack : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = R.string.back_icon.uiText,
            )
        )

        class Drawer : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Menu,
                contentDescription = R.string.menu.uiText,
            )
        )
    }
}
