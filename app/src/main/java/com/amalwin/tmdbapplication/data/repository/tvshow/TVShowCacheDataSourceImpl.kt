package com.amalwin.tmdbapplication.data.repository.tvshow

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow

class TVShowCacheDataSourceImpl: TVShowCacheDataSource {
    private lateinit var tvShowsList: ArrayList<TVShow>
    override suspend fun getTVShows() = tvShowsList

    override suspend fun saveTVShows(tvShows: List<TVShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
}