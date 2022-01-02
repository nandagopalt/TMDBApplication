package com.amalwin.tmdbapplication.data.repository.tvshow

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShows(): List<TVShow>
    suspend fun saveTVShows(tvShows: List<TVShow>)
    suspend fun deleteTVShows()
}