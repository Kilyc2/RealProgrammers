package com.example.realprogrammers.platform.di

import com.example.realprogrammers.data.InMemoryRepository
import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.UseCaseFactory
import com.example.realprogrammers.domain.entities.Programmer
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

@Module(subcomponents = [MainActivityComponent::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun memoryRepositoryProvides(): EntityGateway {
        val programmers = listOf(
            Programmer(
                firstName = "Kilian",
                lastName = "Cerdán",
                emacs = 4,
                caffeine = 4,
                rating = 100,
                interviewDate = Date(),
                isFavourite = true
            ),
            Programmer(
                firstName = "Pancho",
                lastName = "Colate",
                emacs = 1,
                caffeine = 2,
                rating = 42,
                interviewDate = Date(),
                isFavourite = false
            )
        )
        return InMemoryRepository(programmers)
    }

    @Provides
    @Singleton
    fun useCaseFactoryProvider(entityGateway: EntityGateway): UseCaseFactory =
        UseCaseFactory(entityGateway = entityGateway)
}