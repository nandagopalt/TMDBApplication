package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.data.repository.actor.ActorsRepositoryImpl
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorCacheDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorLocalDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.movie.MovieRepositoryImpl
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieCacheDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieLocalDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.tvshow.TVShowsRepositoryImpl
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.amalwin.tmdbapplication.domain.repository.ActorRepository
import com.amalwin.tmdbapplication.domain.repository.MovieRepository
import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepositoryImplInstance(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesActorRepositoryImplInstance(
        actorRemoteDataSource: ActorRemoteDataSource,
        actorLocalDataSource: ActorLocalDataSource,
        actorCacheDataSource: ActorCacheDataSource
    ): ActorRepository {
        return ActorsRepositoryImpl(
            actorRemoteDataSource,
            actorLocalDataSource,
            actorCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesTVShowsRepositoryImplInstance(
        tvShowsRemoteDataSource: TVShowRemoteDataSource,
        tvShowsLocalDataSource: TVShowLocalDataSource,
        tvShowsCacheDataSource: TVShowCacheDataSource
    ): TVShowsRepository {
        return TVShowsRepositoryImpl(
            tvShowsRemoteDataSource,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource
        )
    }

}