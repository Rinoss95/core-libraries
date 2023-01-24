package com.rinoss95.core_ui.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.model.UiText

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun @receiver:StringRes Int?.toStringOrEmpty(count: Int?): String {
    return this?.let { id ->
        count?.let { quantity ->
            pluralStringResource(id = id, count = quantity)
        } ?: stringResource(id)
    } ?: ""
}

fun ImageData.NetworkImage.State.isLoading() = this is ImageData.NetworkImage.State.Loading

fun ImageData.NetworkImage.State.isError() = this is ImageData.NetworkImage.State.Error

@Composable
fun UiText.value(): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes.toStringOrEmpty(count)
    }
}

fun UiText.textFromContext(context: Context): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes?.let { id ->
            count?.let { quantity ->
                context.resources.getQuantityString(id, quantity)
            } ?: context.getString(id)
        } ?: ""
    }
}

fun UiText.isNotBlank(): Boolean {
    return when (this) {
        is UiText.Plain -> value.isNotBlank()
        is UiText.Resource -> stringRes != null
    }
}

fun @receiver:StringRes Int.uiText(count: Int): UiText = UiText.Resource(this, count)

inline val @receiver:StringRes Int.uiText: UiText get() = UiText.Resource(this)

inline val String.uiText: UiText get() = UiText.Plain(this)