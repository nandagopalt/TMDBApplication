package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.presentation.di.artist.ArtistSubComponent
import com.amalwin.tmdbapplication.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbapplication.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTVShowSubComponent(): TVShowSubComponent
}