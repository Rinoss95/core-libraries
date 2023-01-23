package com.rinoss95.core_ui.model

sealed class DrawerEntry(
    val title: UiText = UiText.Plain(),
) {
    data class Header(
        val headerTitle: UiText = UiText.Plain(),
    ) : DrawerEntry(headerTitle)

    data class Item(
        val uiText: UiText = UiText.Plain(),
        val value: UiText = UiText.Plain(),
    ): DrawerEntry(uiText)
}