package com.example.realprogrammers.platform.di

import com.example.realprogrammers.domain.UseCaseFactory
import com.example.realprogrammers.presentation.DetailView
import com.example.realprogrammers.presentation.presenters.DetailPresenter
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    fun presenterProvider(
        view: DetailView,
        useCaseFactory: UseCaseFactory
    ): DetailPresenter = DetailPresenter(view = view, useCaseFactory = useCaseFactory)
}