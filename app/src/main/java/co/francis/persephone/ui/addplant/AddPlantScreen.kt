package co.francis.persephone.ui.addplant

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AddPlantScreen(
    onPlantAdded: () -> Unit
) {
    Text(text = "Add a plant")
}