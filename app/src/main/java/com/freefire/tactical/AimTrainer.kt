package com.freefire.tactical

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AimTrainer() {
    var score by remember { mutableIntStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            "🎯 AIM TRAINER",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            "Practice your tapping accuracy",
            style = MaterialTheme.typography.bodyLarge
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("YOUR SCORE")
                Text(
                    "$score",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }

        Button(
            onClick = {
                score = 0
                isPlaying = true
            }
        ) {
            Text("START TRAINING")
        }

        if (isPlaying) {
            Button(
                onClick = { score++ },
                modifier = Modifier.size(150.dp)
            ) {
                Text(
                    "🎯\nTAP TARGET",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Text("Keep tapping to increase your score!")
        }

        OutlinedButton(
            onClick = {
                isPlaying = false
                score = 0
            }
        ) {
            Text("RESET")
        }
    }
}
