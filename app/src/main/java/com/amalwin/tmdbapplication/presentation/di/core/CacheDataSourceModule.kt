package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorCacheDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl.ActorCacheDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieCacheDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun providesMovieCacheDataSourceImplInstance(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesActorCacheDataSourceImplInstance(): ActorCacheDataSource {
        return ActorCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTVShowCacheDataSourceImplInstance(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }
}