package co.francis.persephone.ui.addplant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import co.francis.persephone.ui.addplant.AddPlantViewModel.Companion.PLANTS_PLACEMENT
import co.francis.persephone.ui.addplant.AddPlantViewModel.Companion.SUNLIGHT_REQUIREMENTS
import co.francis.persephone.ui.addplant.AddPlantViewModel.Companion.WATER_FREQUENCIES

@Composable
fun AddPlantScreen(
    onPlantAdded: () -> Unit,
    addPlantViewModel: AddPlantViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val uiState = addPlantViewModel.uiState.collectAsStateWithLifecycle().value
    Column(
        modifier = Modifier
            .padding(24.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Add a plant",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            value = uiState.name,
            onValueChange = { addPlantViewModel.onNameChanged(it) },
            label = { Text("Plant name") },
            singleLine = true
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            value = uiState.scientificName,
            onValueChange = { addPlantViewModel.onScientificNameChanged(it) },
            label = { Text("Scientific name") },
            singleLine = true
        )

        LabeledSlider(
            label = "Water frequency",
            value = uiState.wateringFrequency,
            onValueChange = { addPlantViewModel.onWateringFrequencyChanged(it) },
            labels = WATER_FREQUENCIES
        )

        LabeledRangeSlider(
            label = "Sunlight requirements",
            value = uiState.sunlightRequirement,
            onValueChange = { addPlantViewModel.onSunlightRequirementChanged(it) },
            labels = SUNLIGHT_REQUIREMENTS
        )

        LabeledSlider(
            label = "Placement",
            value = uiState.placement,
            onValueChange = { addPlantViewModel.onPlacementChanged(it) },
            labels = PLANTS_PLACEMENT
        )

        LabeledCheckbox(
            modifier = Modifier.align(Alignment.Start),
            label = "This plant should be pulverized",
            checked = uiState.shouldPulverize,
            onCheckedChange = { addPlantViewModel.onShouldPulverizeChanged(it) }
        )

        Button(
            onClick = { onPlantAdded() },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Add plant")
        }
    }
}

@Composable
fun LabeledSlider(
    label: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    labels: List<String>
) {
    Text(
        modifier = Modifier.padding(top = 16.dp),
        text = label,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
    )
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 0f..(labels.size - 1).toFloat(),
        steps = labels.size - 2
    )
    Text(
        text = labels[value.toInt()],
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun LabeledRangeSlider(
    label: String,
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    labels: List<String>
) {
    Text(
        modifier = Modifier.padding(top = 16.dp),
        text = label,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
    )
    RangeSlider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 0f..(labels.size - 1).toFloat(),
        steps = labels.size - 2
    )
    val sliderText =
        if (value.start == value.endInclusive) {
            labels[value.start.toInt()]
        } else {
            "${labels[value.start.toInt()]} to ${labels[value.endInclusive.toInt()]}"
        }
    Text(
        text = sliderText,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun LabeledCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 8.dp)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun AddPlantScreenPreview() {
    AddPlantScreen(
        onPlantAdded = {}
    )
}

@Preview
@Composable
fun LabeledSliderPreview() {
    LabeledSlider(
        label = "Water frequency",
        value = 0f,
        onValueChange = {},
        labels = listOf(
            "Never",
            "When the soil is completely dry",
            "When the soil top inch is dry",
            "Keep soil moist"
        )
    )
}