package com.freefire.tactical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

    if (selectedModule == "🎯 Aim Trainer") {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { selectedModule = "" },
                modifier = Modifier.padding(12.dp)
            ) {
                Text("← Back to Dashboard")
            }
            AimTrainer()
        }
    } else {
        val modules = listOf(
            "🎯 Aim Trainer" to "Practice accuracy and reaction time",
            "🔫 Weapon Analysis" to "Compare weapon statistics",
            "🗺️ Map Guide" to "Study locations and tactical routes"
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
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
                        Text(module.second)
                    }
                }
            }
        }
    }
}

