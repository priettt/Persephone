package co.francis.persephone.ui.home

import co.francis.persephone.util.MainDispatcherRule
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LocalPlantsRepositoryTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var repository: LocalPlantsRepository

    @Before
    fun setUp() {
        repository = LocalPlantsRepository(testDispatcher)
    }

    @Test
    fun `fetch plants from repository`() = runTest(testDispatcher) {
        val plants = repository.fetchPlants()
        assertEquals(4, plants.size)
    }
}