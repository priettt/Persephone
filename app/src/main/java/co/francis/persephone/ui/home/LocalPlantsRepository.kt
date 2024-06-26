package co.francis.persephone.ui.home

import co.francis.persephone.di.DispatcherModule.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalPlantsRepository @Inject constructor(
    @IoDispatcher val dispatcher: CoroutineDispatcher
) : PlantsRepository {

    private val storedPlants = mutableListOf(
        Plant("Potus"),
        Plant("Dieffenbachia"),
        Plant("Gomero"),
        Plant("Cactus"),
    )

    override suspend fun fetchPlants(): List<Plant> = withContext(dispatcher) {
        return@withContext storedPlants
    }

    override suspend fun savePlants(plants: List<Plant>): Unit = withContext(dispatcher) {
        storedPlants.addAll(plants)
    }

}


