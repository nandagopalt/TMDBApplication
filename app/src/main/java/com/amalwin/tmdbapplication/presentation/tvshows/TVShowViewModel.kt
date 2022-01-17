package com.amalwin.tmdbapplication.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbapplication.domain.usecase.DeleteTVShowUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetTVShowsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveTVShowUseCase

class TVShowViewModel constructor(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val saveTVShowUseCase: SaveTVShowUseCase,
    private val deleteTVShowsUseCase: DeleteTVShowUseCase
) : ViewModel() {
    init {

    }

    fun getTVShows() = liveData {
            val response = getTVShowsUseCase.execute()
            emit(response)
    }

    fun updateTVShows() = liveData {
        deleteTVShowsUseCase.deleteTVShowUseCase()
        val response = saveTVShowUseCase.execute()
        emit(response)
    }
}