package co.francis.persephone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val plantsRepository: PlantsRepository
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
