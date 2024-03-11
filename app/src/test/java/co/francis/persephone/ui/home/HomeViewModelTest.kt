package co.francis.persephone.ui.home

import co.francis.persephone.util.MainDispatcherRule
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
        viewModel = HomeViewModel(plantsRepository)
    }

    @Test
    fun `fetch plants on view model startup`() {
        // given a repository with plants
        val plants = listOf(
            Plant("Plantita 1", 1),
            Plant("Plantita 2", 2),
            Plant("Plantita 3", 3)
        )
        plantsRepository.setPlants(plants)

        // when the view model is created
        viewModel = HomeViewModel(plantsRepository)

        // then the plants are fetched
        assertEquals(plants, viewModel.uiState.value.plants)
    }

}