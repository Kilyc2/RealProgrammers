package com.example.realprogrammers.platform.di

import com.example.realprogrammers.platform.views.MainActivity
import com.example.realprogrammers.presentation.MainView
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun view(view: MainView) : Builder

        fun build(): MainActivityComponent
    }
}