package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.data.api.TMDBService
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl.ActorRemoteDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule constructor(
    private val apiKey: String,
    private val language: String,
    private val page: Int
) {
    @Singleton
    @Provides
    fun providesMovieRemoteDataSourceImplInstance(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey, language, page)
    }

    @Singleton
    @Provides
    fun providesActorRemoteDataSourceImplInstance(tmdbService: TMDBService): ActorRemoteDataSource {
        return ActorRemoteDataSourceImpl(tmdbService, apiKey, language, page)
    }

    @Singleton
    @Provides
    fun providesTVShowRemoteDataSourceImplInstance(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbService, apiKey, language, page)
    }
}