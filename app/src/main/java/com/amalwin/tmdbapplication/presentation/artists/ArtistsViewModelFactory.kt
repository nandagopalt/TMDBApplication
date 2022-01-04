package com.amalwin.tmdbapplication.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbapplication.domain.usecase.DeleteActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetActorsUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveActorsUseCase

class ArtistsViewModelFactory constructor(
    private val getArtistsUseCase: GetActorsUseCase,
    private val saveArtistsUseCase: SaveActorsUseCase,
    private val deleteArtistsUseCase: DeleteActorsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistsViewModel::class.java))
            return ArtistsViewModel(
                getArtistsUseCase,
                saveArtistsUseCase,
                deleteArtistsUseCase
            ) as T
        throw IllegalArgumentException("View Model Mismatch ${modelClass.simpleName}")
    }
}