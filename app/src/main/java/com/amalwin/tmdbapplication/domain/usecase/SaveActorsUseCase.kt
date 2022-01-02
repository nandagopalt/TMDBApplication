package com.amalwin.tmdbapplication.domain.usecase

import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.domain.repository.ActorRepository

class SaveActorsUseCase constructor(private val actorRepository: ActorRepository) {
    suspend fun execute() = actorRepository.saveActors()
}