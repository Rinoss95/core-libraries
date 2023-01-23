package com.rinoss95.core_ui.model

data class ErrorData(
    val title: UiText = UiText.Plain(),
    val errorImage: ImageData? = null,
    val message: UiText = UiText.Plain(),
    val cta: UiText = UiText.Plain(),
)