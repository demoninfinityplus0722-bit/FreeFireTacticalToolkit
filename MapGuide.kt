
package com.freefire.tactical

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class MapLocation(
    val name: String,
    val description: String,
    val tip: String
)

@Composable
fun MapGuide() {
    val locations = listOf(
        MapLocation(
            "High Ground",
            "An elevated position with a wider view.",
            "Watch your surroundings before moving."
        ),
        MapLocation(
            "Buildings",
            "Structures that can provide cover.",
            "Check entrances and nearby areas."
        ),
        MapLocation(
            "Open Areas",
            "Places with limited natural cover.",
            "Plan your route before crossing."
        ),
        MapLocation(
            "Safe Zone",
            "The playable area shown during a match.",
            "Keep an eye on the zone timer."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "🗺️ MAP GUIDE",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Learn basic map awareness and positioning.")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(locations) { location ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            location.name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(location.description)

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "TACTICAL TIP",
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(location.tip)
                    }
                }
            }
        }
    }
}
