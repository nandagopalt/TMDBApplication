package com.amalwin.tmdbapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amalwin.tmdbapplication.data.model.actor.Actor

@Dao
interface ActorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveActors(actors: List<Actor>)

    @Query("DELETE FROM actor_table")
    suspend fun deleteAllActors()

    @Query("SELECT * FROM actor_table")
    suspend fun getAllActors(): List<Actor>
}