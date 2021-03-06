package com.amalwin.tmdbapplication.data.repository.tvshow.datasource

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShows(): List<TVShow>
    suspend fun saveTVShows(tvShows: List<TVShow>)
}