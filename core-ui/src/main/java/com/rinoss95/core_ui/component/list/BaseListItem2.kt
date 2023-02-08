package com.rinoss95.core_ui.component.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.SubcomposeMeasureScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.rinoss95.core_ui.component.list.internal.ListItemContentPadding
import com.rinoss95.core_ui.component.list.internal.RawListItem
import com.rinoss95.core_ui.util.copy

private enum class SlotId {
    Leading,
    OneLineTest,
    Candidate,
    Actual,
}

@Composable
fun BaseListItem2(
    modifier: Modifier = Modifier,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    headlineText: String = "",
    supportingText: String = "",
) {
    val density = LocalDensity.current

    SubcomposeLayout { constraints: Constraints ->
        val leadingWidth = with(density) {
            if (leading != null) {
                subcompose(
                    SlotId.Leading,
                    leading,
                )[0].measure(constraints).width
            } else {
                0
            }.toDp()
        }

        val hasStartPadding = leadingWidth < 114.dp

        val actualPlaceable = if (supportingText.isBlank()) {
            withoutSupportingText(
                constraints = constraints,
                hasStartPadding = hasStartPadding,
                modifier = modifier,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText
            )
        } else {
            withSupportingText(
                constraints = constraints,
                hasStartPadding = hasStartPadding,
                modifier = modifier,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                supportingText = supportingText,
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

private fun SubcomposeMeasureScope.withSupportingText(
    constraints: Constraints,
    hasStartPadding: Boolean,
    modifier: Modifier,
    leading: (@Composable () -> Unit)?,
    trailing: (@Composable () -> Unit)?,
    headlineText: String,
    supportingText: String,
): Placeable {
    val oneLinePlaceable = subcompose(SlotId.OneLineTest) {
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
            supportingText = ".",
        )
    }[0].measure(constraints)

    val candidate = @Composable {
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
        )
    }

    val candidatePlaceable = subcompose(
        SlotId.Candidate,
        candidate,
    )[0].measure(constraints)

    return if (candidatePlaceable.height <= oneLinePlaceable.height) {
        candidatePlaceable
    } else {
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
            )
        }[0].measure(constraints)
    }
}

private fun SubcomposeMeasureScope.withoutSupportingText(
    constraints: Constraints,
    hasStartPadding: Boolean,
    modifier: Modifier,
    leading: (@Composable () -> Unit)?,
    trailing: (@Composable () -> Unit)?,
    headlineText: String,
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
        )
    }[0].measure(constraints)
}
