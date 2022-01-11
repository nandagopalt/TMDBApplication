package com.amalwin.tmdbapplication.presentation.di.tvshow

import com.amalwin.tmdbapplication.presentation.tvshows.TVShowsActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowsActivity: TVShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}