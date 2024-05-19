package co.francis.persephone.ui.addplant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * THings we should ask for:
 * Name:
 * Scientific name:
 * Water frequency:
 * Should pulverize
 * Sunlight requirements:
 * Interior/exterior:
 * Temperature
 * Fertilizing:
 * Toxicity:
 */

@Composable
fun AddPlantScreen(
    onPlantAdded: () -> Unit
) {
    val scrollState = rememberScrollState()
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

        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            label = { Text("Plant name") },
            singleLine = true
        )

        var scientificName by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            value = scientificName,
            onValueChange = { scientificName = it },
            label = { Text("Scientific name") },
            singleLine = true
        )

        var waterFrequencySliderState by remember { mutableFloatStateOf(0f) }
        LabeledSlider(
            label = "Water frequency",
            value = waterFrequencySliderState,
            onValueChange = { waterFrequencySliderState = it },
            labels = listOf(
                "Never",
                "When the soil is completely dry",
                "When the soil top inch is dry",
                "Keep soil moist"
            )
        )

        val sunlightRequirementsRange = listOf(
            "Low light",
            "Medium light",
            "Bright indirect light",
            "Direct sunlight"
        )
        var sunlightSliderState by remember {
            mutableStateOf(0f..(sunlightRequirementsRange.size - 1).toFloat())
        }
        LabeledRangeSlider(
            label = "Sunlight requirements",
            value = sunlightSliderState,
            onValueChange = { newValue -> sunlightSliderState = newValue },
            labels = sunlightRequirementsRange
        )

        var placementSliderState by remember { mutableFloatStateOf(0f) }
        LabeledSlider(
            label = "Placement",
            value = placementSliderState,
            onValueChange = { placementSliderState = it },
            labels = listOf(
                "Indoors",
                "Both",
                "Outdoors"
            )
        )

        var isInterior by remember { mutableStateOf(false) }
        LabeledCheckbox(
            modifier = Modifier.align(Alignment.Start),
            label = "This plant is an interior plant",
            checked = isInterior,
            onCheckedChange = { isInterior = it }
        )

        var shouldPulverize by remember { mutableStateOf(false) }
        LabeledCheckbox(
            modifier = Modifier.align(Alignment.Start),
            label = "This plant should be pulverized",
            checked = shouldPulverize,
            onCheckedChange = { shouldPulverize = it }
        )
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
    AddPlantScreen { }
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