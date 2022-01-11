package com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl

import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movies = ArrayList<Movie>()
    override suspend fun getPopularMoviesFromCache(): List<Movie> = movies

    override suspend fun savePopularMoviesToCache(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }
}