package com.amalwin.tmdbapplication.data.repository.movie.datasource

import com.amalwin.tmdbapplication.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getPopularMoviesFromDB(): List<Movie>
    suspend fun savePopularMoviesToDB(moviesList: List<Movie>)
    suspend fun deletePopularMoviesFromDB()
}