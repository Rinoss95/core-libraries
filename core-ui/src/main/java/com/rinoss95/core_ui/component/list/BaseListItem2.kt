package com.rinoss95.core_ui.component.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.SubcomposeMeasureScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.list.internal.ListItemContentPadding
import com.rinoss95.core_ui.component.list.internal.RawListItem
import com.rinoss95.core_ui.util.copy

private enum class SlotId {
    Leading,
    Trailing,
    TestSingleLine,
    TestActual,
    Actual,
}

@Composable
fun BaseListItem2(
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    headlineText: String = "",
    supportingText: String = "",
    hasDivider: Boolean = false,
) {
    val density = LocalDensity.current

    SubcomposeLayout { constraints: Constraints ->

        val leadingWidth = width(
            SlotId.Leading,
            density = density,
            constraints = constraints,
            composable = leading,
        )

        val trailingWidth = width(
            SlotId.Trailing,
            density = density,
            constraints = constraints,
            composable = trailing,
        )

        val hasStartPadding = leadingWidth < 114.dp

        val actualPlaceable = if (supportingText.isBlank()) {
            withoutSupportingText(
                constraints = constraints,
                hasStartPadding = hasStartPadding,
                modifier = modifier,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                hasDivider = hasDivider,
            )
        } else {
            withSupportingText(
                constraints = constraints,
                hasStartPadding = hasStartPadding,
                modifier = modifier,
                leading = leading,
                leadingWidth = leadingWidth,
                trailing = trailing,
                trailingWidth = trailingWidth,
                headlineText = headlineText,
                supportingText = supportingText,
                hasDivider = hasDivider,
            )
        }

        layout(
            actualPlaceable.width,
            actualPlaceable.height,
        ) {
            actualPlaceable.placeRelative(0, 0)
        }
    }
}

private fun SubcomposeMeasureScope.width(
    slotId: SlotId,
    density: Density,
    constraints: Constraints,
    composable: (@Composable () -> Unit)?,
): Dp {
    return with(density) {
        if (composable != null) {
            subcompose(slotId, composable)[0].measure(constraints).width
        } else {
            0
        }.toDp()
    }
}

private fun SubcomposeMeasureScope.withSupportingText(
    constraints: Constraints,
    hasStartPadding: Boolean,
    modifier: Modifier,
    leading: (@Composable () -> Unit)?,
    leadingWidth: Dp,
    trailing: (@Composable () -> Unit)?,
    trailingWidth: Dp,
    headlineText: String,
    supportingText: String,
    hasDivider: Boolean,
): Placeable {
    fun test(slotId: SlotId): Int {
        return subcompose(
            slotId,
        ) {
            RawListItem(
                modifier = modifier,
                padding = if (hasStartPadding) {
                    ListItemContentPadding.Small
                } else {
                    ListItemContentPadding.Large.copy(
                        start = 0.dp,
                    )
                },
                verticalAlignment = Alignment.CenterVertically,
                leading = {
                    Box(
                        Modifier.size(
                            width = leadingWidth,
                            height = 1.dp,
                        )
                    )
                },
                trailing = {
                    Box(
                        Modifier.size(
                            width = trailingWidth,
                            height = 1.dp,
                        )
                    )
                },
                headlineText = headlineText,
                supportingText = when (slotId) {
                    SlotId.TestSingleLine -> "."
                    else -> supportingText
                },
                hasDivider = hasDivider,
            )
        }[0].measure(constraints).height
    }

    val singleLineHeight = test(SlotId.TestSingleLine)
    val actualHeight = test(SlotId.TestActual)

    val isMoreLines = singleLineHeight < actualHeight

    return if (isMoreLines) {
        subcompose(SlotId.Actual) {
            RawListItem(
                modifier = modifier,
                padding = ListItemContentPadding.Large.let {
                    if (hasStartPadding) {
                        it
                    } else {
                        it.copy(start = 0.dp)
                    }
                },
                verticalAlignment = Alignment.Top,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                supportingText = supportingText,
                hasDivider = hasDivider,
            )
        }
    } else {
        subcompose(SlotId.Actual) {
            RawListItem(
                modifier = modifier,
                padding = if (hasStartPadding) {
                    ListItemContentPadding.Small
                } else {
                    ListItemContentPadding.Large.copy(
                        start = 0.dp,
                    )
                },
                verticalAlignment = Alignment.CenterVertically,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                supportingText = supportingText,
                hasDivider = hasDivider,
            )
        }
    }[0].measure(constraints)
}

private fun SubcomposeMeasureScope.withoutSupportingText(
    constraints: Constraints,
    hasStartPadding: Boolean,
    modifier: Modifier,
    leading: (@Composable () -> Unit)?,
    trailing: (@Composable () -> Unit)?,
    headlineText: String,
    hasDivider: Boolean,
): Placeable {
    return subcompose(SlotId.Actual) {
        RawListItem(
            modifier = modifier,
            padding = if (hasStartPadding) {
                ListItemContentPadding.Small
            } else {
                ListItemContentPadding.Large.copy(
                    start = 0.dp,
                )
            },
            verticalAlignment = Alignment.CenterVertically,
            leading = leading,
            trailing = trailing,
            headlineText = headlineText,
            supportingText = "",
            hasDivider = hasDivider,
        )
    }[0].measure(constraints)
}
