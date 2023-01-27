package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theme.MyApplicationTheme
import com.rinoss95.core_ui.component.text.HeadlineMedium

class SampleAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                SamplePage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
private fun SamplePage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    HeadlineMedium(text = "Sample Page")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(start = 16.dp),
        ) {
            item {
                Column {
                    ListItemsPage()

                    Box(modifier = Modifier.padding(top = 24.dp))

                    CardsPage()
                }
            }
        }
    }
}
