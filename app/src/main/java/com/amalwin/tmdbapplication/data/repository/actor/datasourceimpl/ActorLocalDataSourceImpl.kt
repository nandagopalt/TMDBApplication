package com.amalwin.tmdbapplication.data.repository.actor.datasourceimpl

import com.amalwin.tmdbapplication.data.db.ActorDAO
import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActorLocalDataSourceImpl constructor(private val actorDAO: ActorDAO): ActorLocalDataSource {
    override suspend fun getActors(): List<Actor> = actorDAO.getAllActors()

    override suspend fun saveActors(actors: List<Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.saveActors(actors)
        }
    }

    override suspend fun deleteActors() {
       CoroutineScope(Dispatchers.IO).launch {
           actorDAO.deleteAllActors()
       }
    }
}