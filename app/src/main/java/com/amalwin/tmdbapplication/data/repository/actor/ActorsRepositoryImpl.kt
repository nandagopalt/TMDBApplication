package com.amalwin.tmdbapplication.data.repository.actor

import android.util.Log
import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.data.model.actor.ActorList
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorCacheDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorLocalDataSource
import com.amalwin.tmdbapplication.data.repository.actor.datasource.ActorRemoteDataSource
import com.amalwin.tmdbapplication.domain.repository.ActorRepository
import retrofit2.Response

class ActorsRepositoryImpl constructor(
    private val actorRemoteDataSource: ActorRemoteDataSource,
    private val actorLocalDataSource: ActorLocalDataSource,
    private val actorCacheDataSource: ActorCacheDataSource
) : ActorRepository {
    override suspend fun getActors(): List<Actor>? {
        return GetActorsFromCache()
    }

    override suspend fun deleteActors() {
        actorLocalDataSource.deleteActors()
    }

    override suspend fun saveActors(): List<Actor> {
        val actors = GetActorsFromAPI()
        deleteActors()
        actorLocalDataSource.saveActors(actors)
        actorCacheDataSource.saveActors(actors)
        return actors
    }

    suspend fun GetActorsFromAPI(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            val response: Response<ActorList> = actorRemoteDataSource.getActors()
            val body = response.body()
            actorsList = body?.actors!!
        } catch (exception: Exception) {
            Log.i("Exception", exception.message.toString())
        }
        return actorsList
    }

    suspend fun GetActorsFromDB(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            actorsList = actorLocalDataSource.getActors()
            if (actorsList == null || actorsList.isEmpty()) {
                actorsList = GetActorsFromAPI()
                actorLocalDataSource.saveActors(actorsList)
            }
        } catch (exception: Exception) {
            Log.i("Exception", exception.message.toString())
        }
        return actorsList
    }

    suspend fun GetActorsFromCache(): List<Actor> {
        lateinit var actorsList: List<Actor>
        try {
            actorsList = actorCacheDataSource.getActors()
            if (actorsList == null || actorsList.isEmpty()) {
                actorsList = GetActorsFromDB()
                actorCacheDataSource.saveActors(actorsList)
            }
        } catch (exception: Exception) {
            Log.i("Exception", exception.message.toString())
        }
        return actorsList
    }

}