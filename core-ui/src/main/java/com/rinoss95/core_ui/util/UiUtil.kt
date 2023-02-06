package com.rinoss95.core_ui.util

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.model.UiText

@Composable
fun @receiver:StringRes Int?.toStringOrEmpty(): String {
    return this?.let {
        stringResource(it)
    } ?: ""
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun @receiver:PluralsRes Int.toStringOrEmpty(count: Int): String {
    return pluralStringResource(
        id = this,
        count = count,
    )
}

fun ImageData.NetworkImage.State.isLoading() = this is ImageData.NetworkImage.State.Loading

fun ImageData.NetworkImage.State.isError() = this is ImageData.NetworkImage.State.Error

@Composable
fun UiText.value(): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes.toStringOrEmpty()
        is UiText.Plural -> pluralRes.toStringOrEmpty(count)
    }
}

fun UiText.textFromContext(context: Context): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes?.let {
            context.getString(it)
        } ?: ""
        is UiText.Plural -> context.resources.getQuantityString(
            this.pluralRes,
            this.count
        )
    }
}

fun UiText.isNotBlank(): Boolean {
    return when (this) {
        is UiText.Plain -> value.isNotBlank()
        is UiText.Resource -> stringRes != null
        is UiText.Plural -> false
    }
}


inline val @receiver:StringRes Int.uiText: UiText get() = UiText.Resource(this)

fun @receiver:PluralsRes Int.uiText(count: Int): UiText = UiText.Plural(this, count)

inline val String.uiText: UiText get() = UiText.Plain(this)

fun PaddingValues.start(layoutDirection: LayoutDirection = LayoutDirection.Ltr): Dp {
    return calculateStartPadding(layoutDirection)
}

fun PaddingValues.top(): Dp {
    return calculateTopPadding()
}

fun PaddingValues.end(layoutDirection: LayoutDirection = LayoutDirection.Ltr): Dp {
    return calculateEndPadding(layoutDirection)
}

fun PaddingValues.bottom(): Dp {
    return calculateBottomPadding()
}

fun PaddingValues.copy(
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
    start: Dp = start(layoutDirection),
    top: Dp = top(),
    end: Dp = end(layoutDirection),
    bottom: Dp = bottom(),
): PaddingValues {
    return PaddingValues(start, top, end, bottom)
}