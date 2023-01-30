package com.example.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.main.model.SampleRoute
import com.rinoss95.core_ui.component.text.HeadlineMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppBar(currentRoute: SampleRoute) {
    TopAppBar(
        title = {
            HeadlineMedium(
                text = currentRoute.displayName,
            )
        }
    )
}