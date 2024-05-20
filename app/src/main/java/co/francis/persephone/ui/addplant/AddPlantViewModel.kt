package co.francis.persephone.ui.addplant

import androidx.lifecycle.ViewModel
import co.francis.persephone.ui.addplant.AddPlantViewModel.Companion.SUNLIGHT_REQUIREMENTS
import kotlinx.coroutines.flow.MutableStateFlow

data class AddPlantUiState(
    val name: String = "",
    val scientificName: String = "",
    val wateringFrequency: Float = 0f,
    val sunlightRequirement: ClosedFloatingPointRange<Float> = 0f..(SUNLIGHT_REQUIREMENTS.size - 1).toFloat(),
    val placement: Float = 0f,
    val shouldPulverize: Boolean = false
)

class AddPlantViewModel : ViewModel() {
    fun onNameChanged(name: String) {
        uiState.value = uiState.value.copy(name = name)
    }

    fun onScientificNameChanged(scientificName: String) {
        uiState.value = uiState.value.copy(scientificName = scientificName)
    }

    fun onWateringFrequencyChanged(frequency: Float) {
        uiState.value = uiState.value.copy(wateringFrequency = frequency)
    }

    fun onSunlightRequirementChanged(sunlightRange: ClosedFloatingPointRange<Float>) {
        uiState.value = uiState.value.copy(sunlightRequirement = sunlightRange)
    }

    fun onPlacementChanged(placement: Float) {
        uiState.value = uiState.value.copy(placement = placement)
    }

    fun onShouldPulverizeChanged(shouldPulverize: Boolean) {
        uiState.value = uiState.value.copy(shouldPulverize = shouldPulverize)
    }

    fun onPlantAdded() {

    }

    val uiState = MutableStateFlow(AddPlantUiState())

    companion object {
        val SUNLIGHT_REQUIREMENTS = listOf(
            "Low light",
            "Medium light",
            "Bright indirect light",
            "Direct sunlight"
        )
        val WATER_FREQUENCIES = listOf(
            "Never",
            "When the soil is completely dry",
            "When the soil top inch is dry",
            "Keep soil moist"
        )
        val PLANTS_PLACEMENT = listOf(
            "Indoors",
            "Outdoors",
            "Both"
        )
    }
}

