package co.francis.persephone.ui.home

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakePlantsRepository : PlantsRepository {

    private val flow = MutableStateFlow(emptyList<Plant>())

    suspend fun emit(value: List<Plant>) {
        flow.emit(value)
    }

    override fun observePlants(): Flow<List<Plant>> = flow

}