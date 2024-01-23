package co.francis.persephone.ui.home

import co.francis.persephone.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val plantsRepository = FakePlantsRepository()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(
            plantsRepository = plantsRepository
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when plants are emitted then uiState emits plants`() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) {
            viewModel.uiState.collect()
        }

        assertEquals(emptyList<Plant>(), viewModel.uiState.value.plants)

        val plants = listOf(
            Plant("Plantita 1", 1),
            Plant("Plantita 2", 2),
            Plant("Plantita 3", 3)
        )
        plantsRepository.emit(plants)
        assertEquals(plants, viewModel.uiState.value.plants)

        collectJob.cancel()
    }

}