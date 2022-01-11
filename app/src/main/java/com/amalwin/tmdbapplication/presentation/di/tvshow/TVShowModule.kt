package com.amalwin.tmdbapplication.presentation.di.tvshow

import com.amalwin.tmdbapplication.domain.usecase.DeleteTVShowUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetTVShowsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveTVShowUseCase
import com.amalwin.tmdbapplication.presentation.tvshows.TVShowViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun providesTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        saveTVShowsUseCase: SaveTVShowUseCase,
        deleteTVShowsUseCase: DeleteTVShowUseCase
    )
            : TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowsUseCase, saveTVShowsUseCase, deleteTVShowsUseCase)
    }
}