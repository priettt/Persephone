package co.francis.persephone.ui.home

class FakePlantsRepository : PlantsRepository {
    private val plants = mutableListOf<Plant>()
    fun setPlants(plants: List<Plant>) {
        this.plants.clear()
        this.plants.addAll(plants)
    }

    override suspend fun fetchPlants() = plants

}