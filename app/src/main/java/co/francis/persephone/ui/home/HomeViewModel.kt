package co.francis.persephone.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel(
    private val plantsRepository: PlantsRepository = PlantsRepository()
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState(plantsRepository.getPlants()))
        private set

}

data class HomeUiState(
    val plants: List<Plant>
)
