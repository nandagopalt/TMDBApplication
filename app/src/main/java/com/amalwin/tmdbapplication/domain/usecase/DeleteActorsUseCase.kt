package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.domain.repository.ActorRepository

class DeleteActorsUseCase constructor(private val actorRepository: ActorRepository) {
    suspend fun execute() = actorRepository.deleteActors()
}