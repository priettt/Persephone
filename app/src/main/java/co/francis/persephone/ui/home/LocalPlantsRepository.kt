package co.francis.persephone.ui.home

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.util.Timer
import kotlin.concurrent.schedule

class LocalPlantsRepository : PlantsRepository {

    init {
        Timer().schedule(5000) {
            plants.update {
                it + Plant("Bonsai") + Plant("Orquidea") + Plant("Calla")
            }
        }
    }

    private val plants = MutableStateFlow(
        listOf(
            Plant("Potus"),
            Plant("Dieffenbachia"),
            Plant("Gomero"),
            Plant("Cactus"),
        )
    )

    override fun observePlants(): Flow<List<Plant>> = plants

}


