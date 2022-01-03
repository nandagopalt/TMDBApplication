package com.amalwin.tmdbapplication.data.repository.tvshow.datasource

import com.amalwin.tmdbapplication.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}