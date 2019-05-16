package com.example.realprogrammers.platform.di

import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.UseCaseFactory
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun getEntityGateway(): EntityGateway
    fun getMainActivityBuilder(): MainActivityComponent.Builder
    fun getDetailActivityBuilder(): DetailActivityComponent.Builder
    fun getUseCaseFactory(): UseCaseFactory
}