package com.rinoss95.core_ui.util

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
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

fun @receiver:PluralsRes Int.uiText(count: Int): UiText = UiText.Resource(this)

inline val String.uiText: UiText get() = UiText.Plain(this)