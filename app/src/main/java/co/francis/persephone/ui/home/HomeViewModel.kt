package co.francis.persephone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    plantsRepository: PlantsRepository = LocalPlantsRepository()
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> =
        plantsRepository
            .observePlants()
            .map { plants -> HomeUiState(plants) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = HomeUiState(emptyList())
            )

}

data class HomeUiState(
    val plants: List<Plant>
)
