package com.amalwin.tmdbapplication.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amalwin.tmdbapplication.domain.usecase.DeleteActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveActorsUseCase

class ArtistsViewModel constructor(
    private val getArtistsUseCase: GetActorsUseCase,
    private val saveArtistsUseCase: SaveActorsUseCase,
    private val deleteArtistsUseCase: DeleteActorsUseCase
) : ViewModel() {

    init {

    }

    fun getArtists() {
        val liveDataResponse = liveData {
            val response = getArtistsUseCase.execute()
            emit(response)
        }
    }

    fun updateArtists() {
        val liveDataResponse = liveData {
            deleteArtistsUseCase.execute()
            val response = saveArtistsUseCase.execute()
            emit(response)
        }
    }

}