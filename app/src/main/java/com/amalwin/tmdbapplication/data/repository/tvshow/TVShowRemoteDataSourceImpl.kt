package com.amalwin.tmdbapplication.data.repository.tvshow

import com.amalwin.tmdbapplication.data.api.TMDBService
import com.amalwin.tmdbapplication.data.model.tvshow.TVShowList
import retrofit2.Response

class TVShowRemoteDataSourceImpl constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val language: String,
    private val page: Int
) :
    TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> {
        return tmdbService.getPopularTVShows(apiKey, language, page)
    }
}