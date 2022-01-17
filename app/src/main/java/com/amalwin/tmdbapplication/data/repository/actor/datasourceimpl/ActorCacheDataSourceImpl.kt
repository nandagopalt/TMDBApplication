package com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl

import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorCacheDataSource

class ActorCacheDataSourceImpl: ActorCacheDataSource {
    private val actorsList = ArrayList<Actor>()
    override suspend fun getActors(): List<Actor> = actorsList

    override suspend fun saveActors(actors: List<Actor>) {
        actorsList.clear()
        actorsList.addAll(actors)
    }
}