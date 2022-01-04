package com.amalwin.tmdbapplication.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbapplication.domain.usecase.DeleteTVShowUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetTVShowsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveTVShowUseCase

class TVShowViewModelFactory constructor(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val saveTVShowsUseCase: SaveTVShowUseCase,
    private val deleteTVShowsUseCase: DeleteTVShowUseCase
) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TVShowViewModel::class.java))
            return TVShowViewModel(getTVShowsUseCase, saveTVShowsUseCase, deleteTVShowsUseCase) as T
        throw IllegalArgumentException("View Model Mismatch ${modelClass.simpleName}")
    }
}