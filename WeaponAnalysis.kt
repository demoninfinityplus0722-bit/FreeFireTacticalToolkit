package com.freefire.tactical

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class Weapon(
    val name: String,
    val category: String,
    val damage: Int,
    val range: Int,
    val accuracy: Int
)

@Composable
fun WeaponAnalysis() {
    val weapons = listOf(
        Weapon("Assault Rifle A", "Assault Rifle", 85, 75, 80),
        Weapon("SMG A", "Submachine Gun", 65, 45, 90),
        Weapon("Sniper A", "Sniper Rifle", 95, 100, 70),
        Weapon("Shotgun A", "Shotgun", 100, 25, 55)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "WEAPON ANALYSIS",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Compare example weapon attributes.")

        Text(
            "These are sample values, not official game statistics.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(weapons) { weapon ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            weapon.name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(weapon.category)
                        Text("Damage: ${weapon.damage}/100")
                        Text("Range: ${weapon.range}/100")
                        Text("Accuracy: ${weapon.accuracy}/100")
                    }
                }
            }
        }
    }
}
