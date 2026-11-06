package com.freefire.tactical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TacticalDashboard()
            }
        }
    }
}

@Composable
fun TacticalDashboard() {
    var selectedModule by remember { mutableStateOf("") }

    val modules = listOf(
        "🎯 Aim Trainer" to "Practice accuracy and reaction time.",
        "🔫 Weapon Analysis" to "Compare weapon statistics.",
        "🗺️ Map Guide" to "Study locations and tactical routes."
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "FREE FIRE",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    "TACTICAL TOOLKIT",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text("Your gameplay training companion")
            }

            item {
                Text(
                    "TRAINING MODULES",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            items(modules) { module ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { selectedModule = module.first }
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            module.first,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(module.second)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "TAP TO OPEN →",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            item {
                if (selectedModule.isNotEmpty()) {
                    Text(
                        "Selected: $selectedModule",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Training module coming soon!")
                }
            }
        }
    }
}
