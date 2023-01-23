package com.rinoss95.core_ui.model

data class PageState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val error: ErrorData? = null,
    val snackbar: SnackbarData? = null,
)