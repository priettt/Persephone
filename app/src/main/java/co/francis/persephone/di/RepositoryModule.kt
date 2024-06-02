package co.francis.persephone.di

import co.francis.persephone.ui.home.LocalPlantsRepository
import co.francis.persephone.ui.home.PlantsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPlantsRepository(localPlantsRepository: LocalPlantsRepository): PlantsRepository
}