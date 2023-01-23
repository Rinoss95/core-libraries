package com.rinoss95.core_ui.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rinoss95.core_ui.model.ImageData
import com.rinoss95.core_ui.model.UiText

@Composable
fun @receiver:StringRes Int?.toStringOrEmpty(): String {
    return this?.let {
        stringResource(it)
    } ?: ""
}

fun ImageData.NetworkImage.State.isLoading() = this is ImageData.NetworkImage.State.Loading

fun ImageData.NetworkImage.State.isError() = this is ImageData.NetworkImage.State.Error

@Composable
fun UiText.value(): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes.toStringOrEmpty()
    }
}

fun UiText.textFromContext(context: Context): String {
    return when (this) {
        is UiText.Plain -> value
        is UiText.Resource -> stringRes?.let {
            context.getString(it)
        } ?: ""
    }
}

fun UiText.isNotBlank(): Boolean {
    return when (this) {
        is UiText.Plain -> value.isNotBlank()
        is UiText.Resource -> stringRes != null
    }
}


inline val @receiver:StringRes Int.uiText: UiText get() = UiText.Resource(this)

inline val String.uiText: UiText get() = UiText.Plain(this)