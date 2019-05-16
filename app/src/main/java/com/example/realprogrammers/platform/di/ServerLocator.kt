package com.example.realprogrammers.platform.di

import com.example.realprogrammers.presentation.DetailView
import com.example.realprogrammers.presentation.MainView

interface ServerLocator {
    fun getMainComponent(view: MainView): MainActivityComponent

    fun getDetailComponent(view: DetailView): DetailActivityComponent
}