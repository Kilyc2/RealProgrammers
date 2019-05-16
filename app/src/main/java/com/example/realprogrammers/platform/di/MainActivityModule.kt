package com.example.realprogrammers.platform.di

import com.example.realprogrammers.domain.UseCaseFactory
import com.example.realprogrammers.presentation.MainView
import com.example.realprogrammers.presentation.presenters.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun presenterProvider(
        view: MainView,
        useCaseFactory: UseCaseFactory
    ): MainPresenter =
        MainPresenter(view = view, useCaseFactory = useCaseFactory)

}