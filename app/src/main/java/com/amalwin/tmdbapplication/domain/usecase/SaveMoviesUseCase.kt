package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.domain.repository.MovieRepository

class SaveMoviesUseCase constructor(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.saveMovies()
}