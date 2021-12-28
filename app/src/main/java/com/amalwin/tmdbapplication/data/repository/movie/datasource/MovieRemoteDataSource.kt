package com.amalwin.tmdbapplication.data.repository.movie.datasource

import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}