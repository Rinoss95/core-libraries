package com.rinoss95.core_ui.model

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

sealed class UiText {
    data class Resource(
        @StringRes val stringRes: Int? = null,
    ) : UiText()

    data class Plural(
        @PluralsRes val pluralRes: Int,
        val count: Int,
    ) : UiText()

    data class Plain(
        val value: String = ""
    ) : UiText()
}