package com.amalwin.tmdbapplication.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.amalwin.tmdbapplication.data.db.ActorDAO
import com.amalwin.tmdbapplication.data.db.MovieDAO
import com.amalwin.tmdbapplication.data.db.TMDBDatabase
import com.amalwin.tmdbapplication.data.db.TVShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabaseModule(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "TMDB_database").build()
    }

    @Singleton
    @Provides
    fun providesMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.getMovieDAO()
    }

    @Singleton
    @Provides
    fun providesActorDAO(tmdbDatabase: TMDBDatabase): ActorDAO {
        return tmdbDatabase.getActorDAO()
    }

    @Singleton
    @Provides
    fun providesTVShowDAO(tmdbDatabase: TMDBDatabase): TVShowDAO {
        return tmdbDatabase.getTVShowDAO()
    }
}