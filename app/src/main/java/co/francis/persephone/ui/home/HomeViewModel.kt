package co.francis.persephone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val plantsRepository: PlantsRepository = PlantsRepository()
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
