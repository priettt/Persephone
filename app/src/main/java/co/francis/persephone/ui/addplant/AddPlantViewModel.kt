package co.francis.persephone.ui.addplant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.francis.persephone.ui.addplant.AddPlantViewModel.Companion.SUNLIGHT_REQUIREMENTS
import co.francis.persephone.ui.home.Plant
import co.francis.persephone.ui.home.PlantsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPlantViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository
) : ViewModel() {
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
        if (uiState.value.name.isBlank()) return
        viewModelScope.launch {
            plantsRepository.savePlants(
                listOf(
                    Plant(uiState.value.name)
                )
            )
        }
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

data class AddPlantUiState(
    val name: String = "",
    val scientificName: String = "",
    val wateringFrequency: Float = 0f,
    val sunlightRequirement: ClosedFloatingPointRange<Float> = 0f..(SUNLIGHT_REQUIREMENTS.size - 1).toFloat(),
    val placement: Float = 0f,
    val shouldPulverize: Boolean = false
)
