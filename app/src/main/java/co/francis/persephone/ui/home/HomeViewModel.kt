package co.francis.persephone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val plantsRepository: PlantsRepository = LocalPlantsRepository()
) : ViewModel() {

    val uiState = MutableStateFlow(HomeUiState(emptyList()))

    init {
        viewModelScope.launch {
            uiState.value = HomeUiState(
                plantsRepository.fetchPlants()
            )
        }
    }
}

data class HomeUiState(
    val plants: List<Plant>
)
