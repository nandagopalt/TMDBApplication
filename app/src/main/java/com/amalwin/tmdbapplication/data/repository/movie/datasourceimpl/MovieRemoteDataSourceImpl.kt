package com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl

import com.amalwin.tmdbapplication.data.api.TMDBService
import com.amalwin.tmdbapplication.data.model.movie.MovieList
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                private val apiKey: String,
                                private val language: String,
                                private val page: Int): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey, language, page)
}