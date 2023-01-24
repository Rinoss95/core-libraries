package com.rinoss95.core_ui.model

import androidx.annotation.StringRes

sealed class UiText {
    data class Resource(
        @StringRes val stringRes: Int? = null,
        val count: Int? = null,
    ) : UiText()

    data class Plain(
        val value: String = ""
    ) : UiText()
}