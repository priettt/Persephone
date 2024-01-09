package co.francis.persephone.ui.home

class PlantsRepository {
    fun getPlants(): List<Plant> {
        return listOf(
            Plant("Potus"),
            Plant("Dieffenbachia"),
            Plant("Gomero"),
            Plant("Cactus"),
            Plant("Bonsai"),
            Plant("Orquidea"),
            Plant("Calla"),
            Plant("Crisantemo"),
            Plant("Lirio"),
            Plant("Tulipan"),
            Plant("Rosa"),
        )
    }
}

