package com.amalwin.tmdbapplication.data.repository.actor.datasource

import com.amalwin.tmdbapplication.data.model.actor.Actor

interface ActorLocalDataSource {
    suspend fun getActors(): List<Actor>
    suspend fun saveActors(actors: List<Actor>)
    suspend fun deleteActors()
}