package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.domain.repository.MovieRepository

class DeleteMoviesUseCase constructor(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.deleteMovies()
}