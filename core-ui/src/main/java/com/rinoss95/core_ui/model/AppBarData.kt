package com.rinoss95.core_ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import com.rinoss95.core_ui.R

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
        object Search : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Search,
                contentDescriptionRes = R.string.search,
            )
        )

        object Home : Action(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Home,
                contentDescriptionRes = R.string.home,
            )
        )
    }

    sealed class Navigation(
        val icon: ImageData,
    ) {
        object GoBack : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.ArrowBack,
                contentDescriptionRes = R.string.back_icon,
            )
        )

        object Drawer : Navigation(
            ImageData.IconImageData(
                imageVector = Icons.Filled.Menu,
                contentDescriptionRes = R.string.menu,
            )
        )
    }
}
