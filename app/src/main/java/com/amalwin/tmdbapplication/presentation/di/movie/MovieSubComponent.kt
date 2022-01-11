package com.amalwin.tmdbapplication.presentation.di.movie

import com.amalwin.tmdbapplication.presentation.movies.MoviesActivity
import dagger.Subcomponent
import javax.inject.Singleton

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}