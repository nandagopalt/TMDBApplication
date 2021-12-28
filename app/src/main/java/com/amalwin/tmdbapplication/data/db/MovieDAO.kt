package com.amalwin.tmdbapplication.data.db

import androidx.room.*
import com.amalwin.tmdbapplication.data.model.movie.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies():List<Movie>
}