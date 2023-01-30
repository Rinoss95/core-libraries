package com.example.main.model

enum class AppRoute(
    val id: String,
    val displayName: String,
) {
    ListPage("list", "List"),
    CardsPage("cards", "Cards"),
    SettingsPage("settings", "Settings"),
}