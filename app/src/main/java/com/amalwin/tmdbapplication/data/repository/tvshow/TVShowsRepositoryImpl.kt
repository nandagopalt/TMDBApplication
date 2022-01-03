package com.amalwin.tmdbapplication.data.repository.tvshow

import android.util.Log
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.amalwin.tmdbapplication.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository

class TVShowsRepositoryImpl constructor(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) :
    TVShowsRepository {
    override suspend fun getTVShows(): List<TVShow>?  = getTVShowsFromCache()

    override suspend fun deleteTVShows() {
        tvShowLocalDataSource.deleteTVShows()
    }

    override suspend fun saveTVShows(): List<TVShow> {
        val tvShowsList = getTVShowsFromAPI()
        deleteTVShows()
        tvShowCacheDataSource.saveTVShows(tvShowsList)
        tvShowLocalDataSource.saveTVShows(tvShowsList)
        return tvShowsList
    }

    private suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            tvShowsList = body?.TVShows!!
        } catch (exception: Exception) {
            Log.i("Exception", "Please check the exception")
        }
        return tvShowsList
    }

    private suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            tvShowsList = tvShowLocalDataSource.getTVShows()
            if (tvShowsList == null || tvShowsList.isEmpty()) {
                tvShowsList = getTVShowsFromAPI()
                tvShowLocalDataSource.saveTVShows(tvShowsList)
            }
        } catch (exception: Exception) {
            Log.i("Exception", "Please check the exception")
        }
        return tvShowsList
    }

    private suspend fun getTVShowsFromCache(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>
        try {
            tvShowsList = tvShowCacheDataSource.getTVShows()
            if (tvShowsList == null || tvShowsList.isEmpty()) {
                tvShowsList = getTVShowsFromDB()
                tvShowCacheDataSource.saveTVShows(tvShowsList)
            }
        } catch (exception: Exception) {
            Log.i("Exception", "Please check the exception")
        }
        return tvShowsList
    }
}