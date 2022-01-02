package com.amalwin.tmdbapplication.data.repository.tvshow

import com.amalwin.tmdbapplication.data.db.TVShowDAO
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl constructor(private val tvShowDAO: TVShowDAO) : TVShowLocalDataSource {
    override suspend fun getTVShows(): List<TVShow> = tvShowDAO.getAllTVShows()

    override suspend fun saveTVShows(tvShows: List<TVShow>) {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDAO.saveTVShows(tvShows)
       }
    }

    override suspend fun deleteTVShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTVShows()
        }
    }
}