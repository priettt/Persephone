package co.francis.persephone.ui.home

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.util.Timer
import kotlin.concurrent.schedule

class PlantsRepository {

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

    fun observePlants(): Flow<List<Plant>> = plants

//            Plant("Potus"),
//            Plant("Dieffenbachia"),
//            Plant("Gomero"),
//            Plant("Cactus"),
//            Plant("Bonsai"),
//            Plant("Orquidea"),
//            Plant("Calla"),
//            Plant("Crisantemo"),
//            Plant("Lirio"),
//            Plant("Tulipan"),
//            Plant("Rosa"),
}


