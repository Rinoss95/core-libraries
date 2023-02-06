package com.rinoss95.core_ui.component.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Constraints
import com.rinoss95.core_ui.component.list.internal.ListItemContentPadding
import com.rinoss95.core_ui.component.list.internal.RawListItem

private enum class ListItemSubcompose {
    OneLine,
    OneLineTest,
    Actual,
}

@Composable
fun BaseListItem2(
    modifier: Modifier = Modifier,
    hasStartPadding: Boolean = true,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    headlineText: String = "",
    supportingText: String = "",
) {
    if (supportingText.isBlank()) {
        return RawListItem(
            modifier = modifier,
            padding = ListItemContentPadding.Small,
            hasStartPadding = hasStartPadding,
            verticalAlignment = Alignment.CenterVertically,
            leading = leading,
            trailing = trailing,
            headlineText = headlineText,
            supportingText = "",
        )
    }

    SubcomposeLayout { constraints: Constraints ->
        val oneLine = @Composable {
            RawListItem(
                modifier = modifier,
                padding = ListItemContentPadding.Small,
                hasStartPadding = hasStartPadding,
                verticalAlignment = Alignment.CenterVertically,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                supportingText = ".",
            )
        }

        val listItemTest = @Composable {
            RawListItem(
                modifier = modifier,
                padding = ListItemContentPadding.Small,
                hasStartPadding = hasStartPadding,
                verticalAlignment = Alignment.CenterVertically,
                leading = leading,
                trailing = trailing,
                headlineText = headlineText,
                supportingText = supportingText,
            )
        }

        val oneLinePlaceable = subcompose(
            ListItemSubcompose.OneLine,
            oneLine,
        )[0].measure(
            constraints.copy(
                minWidth = 0,
                minHeight = 0,
            ),
        )

        val listItemTestPlaceable = subcompose(
            ListItemSubcompose.OneLineTest,
            listItemTest,
        )[0].measure(
            constraints.copy(
                minWidth = 0,
                minHeight = 0,
            ),
        )

        val listItemResult = if (listItemTestPlaceable.height <= oneLinePlaceable.height) {
            listItemTest
        } else {
            {
                RawListItem(
                    modifier = modifier,
                    padding = ListItemContentPadding.Large,
                    hasStartPadding = hasStartPadding,
                    verticalAlignment = Alignment.Top,
                    leading = leading,
                    trailing = trailing,
                    headlineText = headlineText,
                    supportingText = supportingText,
                )
            }
        }

        val listItemResultPlaceable = if (listItemTestPlaceable.height <= oneLinePlaceable.height) {
            listItemTestPlaceable
        } else {
            subcompose(
                ListItemSubcompose.Actual,
                listItemResult,
            )[0].measure(constraints)
        }


        layout(
            listItemResultPlaceable.width,
            listItemResultPlaceable.height,
        ) {
            listItemResultPlaceable.placeRelative(0, 0)
        }
    }
}