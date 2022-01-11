package com.amalwin.tmdbapplication.presentation.di.artist

import com.amalwin.tmdbapplication.domain.usecase.DeleteActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveActorsUseCase
import com.amalwin.tmdbapplication.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun providesArtistsViewModelFactory(
        getArtistsUseCase: GetActorsUseCase,
        saveActorsUseCase: SaveActorsUseCase,
        deleteActorsUseCase: DeleteActorsUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCase, saveActorsUseCase, deleteActorsUseCase)
    }
}