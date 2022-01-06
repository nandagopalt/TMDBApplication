package com.amalwin.tmdbapplication.presentation.di.movie

import com.amalwin.tmdbapplication.domain.usecase.DeleteMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveMoviesUseCase
import com.amalwin.tmdbapplication.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {
    @MovieScope
    @Singleton
    @Provides
    fun providesMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase, saveMoviesUseCase: SaveMoviesUseCase, deleteMoviesUseCase: DeleteMoviesUseCase): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, saveMoviesUseCase, deleteMoviesUseCase)
    }

}