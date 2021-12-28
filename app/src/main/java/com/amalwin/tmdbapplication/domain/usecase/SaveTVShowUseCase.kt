package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository

class SaveTVShowUseCase constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend fun execute(): List<TVShow>? = tvShowsRepository.saveTVShows()
}