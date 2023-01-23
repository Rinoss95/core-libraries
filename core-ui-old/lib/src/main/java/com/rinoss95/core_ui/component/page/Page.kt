package com.rinoss95.core_ui.component.page

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.rinoss95.core_ui.component.transitions.EnterTransitions
import com.rinoss95.core_ui.component.transitions.ExitTransitions
import com.rinoss95.core_ui.model.PageState
import com.rinoss95.core_ui.model.SnackbarData
import com.rinoss95.core_ui.theme.LocalSpacing

@Composable
fun Page(
    modifier: Modifier = Modifier,
    horizontalMargin: Dp = LocalSpacing.current.margin.horizontalPage,
    state: PageState = PageState(),
    onRetryClick: () -> Unit = {},
    onShowSnackbar: (SnackbarData) -> Unit = {},
    contentEnterTransition: EnterTransition = EnterTransitions.SlideIn,
    contentExitTransition: ExitTransition = ExitTransitions.SlideOut,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    loadingContent: @Composable () -> Unit = {
        LoadingComponent()
    },
    content: @Composable () -> Unit = {},
) {
    LaunchedEffect(key1 = state.snackbar) {
        state.snackbar?.let {
            onShowSnackbar(it)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = horizontalMargin,
            ),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        AnimatedVisibility(
            visible = state.isError,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            state.error?.let { uiError ->
                ErrorComponent(
                    modifier = Modifier.fillMaxHeight(),
                    error = uiError,
                    onRetryClick = onRetryClick,
                )
            }
        }

        AnimatedVisibility(
            visible = state.isLoading
        ) {
            loadingContent()
        }

        AnimatedVisibility(
            visible = state.isSuccess,
            enter = contentEnterTransition,
            exit = contentExitTransition
        ) {
            content()
        }
    }
}