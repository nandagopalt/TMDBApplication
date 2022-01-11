package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.presentation.di.artist.ArtistSubComponent
import com.amalwin.tmdbapplication.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbapplication.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        CacheDataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun getMovieSubComponent(): MovieSubComponent.Factory
    fun getArtistSubComponent(): ArtistSubComponent.Factory
    fun getTVShowSubComponent(): TVShowSubComponent.Factory
}