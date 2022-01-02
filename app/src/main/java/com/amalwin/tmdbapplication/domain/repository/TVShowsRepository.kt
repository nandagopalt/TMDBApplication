package com.amalwin.tmdbapplication.domain.repository

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

interface TVShowsRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun deleteTVShows()
    suspend fun saveTVShows(): List<TVShow>
}