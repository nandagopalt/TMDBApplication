package com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl

import com.amalwin.tmdbapplication.data.api.TMDBService
import com.amalwin.tmdbapplication.data.model.actor.ActorList
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorRemoteDataSource
import retrofit2.Response

class ActorRemoteDataSourceImpl constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val language: String,
    private val page: Int
) : ActorRemoteDataSource {
    override suspend fun getActors(): Response<ActorList> {
        return tmdbService.getPopularActors(apiKey, language, page )
    }
}