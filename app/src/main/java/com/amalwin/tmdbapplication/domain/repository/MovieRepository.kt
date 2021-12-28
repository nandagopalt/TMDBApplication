package com.amalwin.tmdbapplication.domain.repository

import com.amalwin.tmdbapplication.data.model.movie.Movie

interface MovieRepository {
    suspend fun getAllMovies(): List<Movie>?
    suspend fun deleteMovies()
    suspend fun saveMovies(): List<Movie>?
}