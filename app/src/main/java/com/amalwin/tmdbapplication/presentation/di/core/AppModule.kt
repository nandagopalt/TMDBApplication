package com.amalwin.tmdbapplication.presentation.di.core

import android.content.Context
import com.amalwin.tmdbapplication.presentation.di.artist.ArtistSubComponent
import com.amalwin.tmdbapplication.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbapplication.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [ArtistSubComponent::class, MovieSubComponent::class, TVShowSubComponent::class])
class AppModule constructor(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}