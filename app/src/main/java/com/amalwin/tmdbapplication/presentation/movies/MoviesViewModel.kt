package com.amalwin.tmdbapplication.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.domain.usecase.DeleteMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveMoviesUseCase

class MoviesViewModel constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val saveMoviesUseCase: SaveMoviesUseCase,
    private val deleteMoviesUseCase: DeleteMoviesUseCase
) : ViewModel() {
    init {

    }

    fun getMovies(): LiveData<List<Movie>> {
       val responseLiveData = liveData<List<Movie>> {
           val response =  getMoviesUseCase.execute()
           emit(response!!)
        }
        return responseLiveData
    }

    fun updateMovies() {
        val responseLiveData = liveData<List<Movie>> {
           deleteMoviesUseCase.execute()
           val response = saveMoviesUseCase.execute()
            emit(response!!)
        }
    }
}