package com.amalwin.tmdbapplication.domain.repository

import com.amalwin.tmdbapplication.data.model.actor.Actor

interface ActorRepository {
    suspend fun getActors(): List<Actor>?
    suspend fun deleteActors()
    suspend fun saveActors(): List<Actor>?
}