package com.example.realprogrammers.platform.di

import com.example.realprogrammers.platform.views.DetailActivity
import com.example.realprogrammers.presentation.DetailView
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [DetailActivityModule::class]
)
interface DetailActivityComponent {
    fun inject(activity: DetailActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun view(view: DetailView): Builder

        fun build(): DetailActivityComponent
    }
}