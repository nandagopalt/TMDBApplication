package com.amalwin.tmdbapplication.data.repository.actor.datasource

import com.amalwin.tmdbapplication.data.model.actor.ActorList
import retrofit2.Response

interface ActorRemoteDataSource {
    suspend fun getActors(): Response<ActorList>
}