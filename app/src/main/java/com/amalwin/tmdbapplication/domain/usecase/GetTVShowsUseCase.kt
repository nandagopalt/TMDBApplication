package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository

class GetTVShowsUseCase constructor(private val tvShowRepository: TVShowsRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}