package com.amalwin.tmdbapplication.data.repository.movie.datasource

import com.amalwin.tmdbapplication.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getPopularMoviesFromCache(): List<Movie>
    suspend fun savePopularMoviesToCache(movies: List<Movie>)
}