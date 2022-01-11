package com.amalwin.tmdbapplication.presentation.di.artist

import com.amalwin.tmdbapplication.presentation.artists.ArtistsActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}