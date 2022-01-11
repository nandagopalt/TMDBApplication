package com.amalwin.tmdbapplication.presentation

import android.app.Application
import com.amalwin.tmdbapplication.BuildConfig
import com.amalwin.tmdbapplication.presentation.di.artist.ArtistSubComponent
import com.amalwin.tmdbapplication.presentation.di.core.*
import com.amalwin.tmdbapplication.presentation.di.movie.MovieSubComponent
import com.amalwin.tmdbapplication.presentation.di.tvshow.TVShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY, "EN", 1)).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.getMovieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.getArtistSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.getTVShowSubComponent().create()
    }
}