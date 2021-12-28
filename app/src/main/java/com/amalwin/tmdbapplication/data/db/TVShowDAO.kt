package com.amalwin.tmdbapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

@Dao
interface TVShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("DELETE FROM tvshow_table")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM tvshow_table")
    suspend fun getAllTVShows(): List<TVShow>
}