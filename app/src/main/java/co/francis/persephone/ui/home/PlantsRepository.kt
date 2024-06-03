package co.francis.persephone.ui.home

interface PlantsRepository {
    suspend fun fetchPlants(): List<Plant>

    suspend fun savePlants(plants: List<Plant>)
}