package co.francis.persephone.ui.home

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Timer
import kotlin.concurrent.schedule

class LocalPlantsRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlantsRepository {

    private val plants = mutableListOf(
        Plant("Potus"),
        Plant("Dieffenbachia"),
        Plant("Gomero"),
        Plant("Cactus"),
    )

    override suspend fun fetchPlants(): List<Plant> = withContext(dispatcher) {
        return@withContext plants
    }

}


