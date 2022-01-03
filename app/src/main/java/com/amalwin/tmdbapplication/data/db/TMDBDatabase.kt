package com.amalwin.tmdbapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

@Database(entities = [Movie::class, Actor::class, TVShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun getMovieDAO(): MovieDAO
    abstract fun getActorDAO(): ActorDAO
    abstract fun getTVShowDAO(): TVShowDAO
}