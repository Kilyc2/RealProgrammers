package com.example.realprogrammers.platform

import android.app.Application
import com.example.realprogrammers.platform.di.DaggerApplicationComponent
import com.example.realprogrammers.platform.di.DetailActivityComponent
import com.example.realprogrammers.platform.di.MainActivityComponent
import com.example.realprogrammers.platform.di.ServerLocator
import com.example.realprogrammers.presentation.DetailView
import com.example.realprogrammers.presentation.MainView

class App : Application(), ServerLocator {

    override fun getMainComponent(view: MainView): MainActivityComponent =
        DaggerApplicationComponent.create().getMainActivityBuilder().view(view).build()

    override fun getDetailComponent(view: DetailView): DetailActivityComponent =
        DaggerApplicationComponent.create().getDetailActivityBuilder().view(view).build()

}
