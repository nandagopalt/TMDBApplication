package com.amalwin.tmdbapplication.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbapplication.domain.usecase.DeleteMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val saveMoviesUseCase: SaveMoviesUseCase,
    private val deleteMoviesUseCase: DeleteMoviesUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //if (modelClass.isAssignableFrom(MoviesViewModel::class.java))
            return MoviesViewModel(getMoviesUseCase, saveMoviesUseCase, deleteMoviesUseCase) as T
        //throw IllegalArgumentException("View Model Mismatch ! " + modelClass.simpleName)
    }
}