package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.data.db.ActorDAO
import com.amalwin.tmdbapplication.data.db.MovieDAO
import com.amalwin.tmdbapplication.data.db.TVShowDAO
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorLocalDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl.ActorLocalDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieLocalDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule() {

    @Singleton
    @Provides
    fun providesMovieLocalDataSourceImplInstance(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun providesActorLocalDataSourceImplInstance(actorDAO: ActorDAO): ActorLocalDataSource {
        return ActorLocalDataSourceImpl(actorDAO)
    }

    @Singleton
    @Provides
    fun providesTVShowLocalDataSourceImplInstance(tvShowDAO: TVShowDAO): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDAO)
    }

}