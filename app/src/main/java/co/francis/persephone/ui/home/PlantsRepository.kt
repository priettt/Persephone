package co.francis.persephone.ui.home

import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun observePlants(): Flow<List<Plant>>
}