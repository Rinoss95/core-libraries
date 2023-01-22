package com.rinoss95.core_util

import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

private suspend fun <T> Throwable.manage(
    fallback: suspend () -> T
): T = if (this is CancellationException) {
    throw this
} else {
    fallback()
}

private fun <T> Throwable.manageAsync(
    fallback: () -> T
): T = if (this is CancellationException) {
    throw this
} else {
    fallback()
}

suspend fun <T> tryCatch(
    fallback: suspend (Throwable) -> T,
    block: suspend () -> T,
) = try {
    block()
} catch (t: Throwable) {
    t.manage {
        fallback(t)
    }
}

fun <T> tryCatchAsync(
    fallback: (Throwable) -> T,
    block: () -> T,
) = try {
    block()
} catch (t: Throwable) {
    t.manageAsync {
        fallback(t)
    }
}

fun <T> flowEmit(block: suspend () -> T): Flow<T> = flow {
    emit(
        block()
    )
}

fun <T> flowEmitAll(block: () -> Flow<T>): Flow<T> = flow {
    emitAll(
        block()
    )
}

fun <T> Flow<T>.onError(
    action: suspend FlowCollector<T>.(Throwable) -> Unit
): Flow<T> = catch { t ->
    t.manage {
        action(t)
    }
}