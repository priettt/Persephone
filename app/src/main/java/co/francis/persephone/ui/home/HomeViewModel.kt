package co.francis.persephone.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val plantsRepository: PlantsRepository = PlantsRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(plantsRepository.getPlants()))
    val uiState = _uiState.asStateFlow()

}

data class HomeUiState(
    val plants: List<Plant>
)
