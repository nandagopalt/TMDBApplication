package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository

class DeleteTVShowUseCase constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend fun deleteTVShowUseCase() = tvShowsRepository.deleteTVShows()
}