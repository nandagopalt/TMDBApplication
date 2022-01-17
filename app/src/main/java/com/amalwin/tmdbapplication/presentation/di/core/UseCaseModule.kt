package com.amalwin.tmdbapplication.presentation.di.core

import com.amalwin.tmdbapplication.domain.repository.ActorRepository
import com.amalwin.tmdbapplication.domain.repository.MovieRepository
import com.amalwin.tmdbapplication.domain.repository.TVShowsRepository
import com.amalwin.tmdbapplication.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun providesGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun providesSaveMoviesUseCase(movieRepository: MovieRepository): SaveMoviesUseCase {
        return SaveMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteMoviesUseCase(movieRepository: MovieRepository): DeleteMoviesUseCase {
        return DeleteMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun providesGetActorsUseCase(actorsRepository: ActorRepository): GetActorsUseCase {
        return GetActorsUseCase(actorsRepository)
    }

    @Singleton
    @Provides
    fun providesSaveActorsUseCase(actorsRepository: ActorRepository): SaveActorsUseCase {
        return SaveActorsUseCase(actorsRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteActorsUseCase(actorsRepository: ActorRepository): DeleteActorsUseCase {
        return DeleteActorsUseCase(actorsRepository)
    }

    @Singleton
    @Provides
    fun providesGetTVShowsUseCase(tvShowsRepository: TVShowsRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowsRepository)
    }

    @Singleton
    @Provides
    fun providesSaveTVShowsUseCase(tvShowsRepository: TVShowsRepository): SaveTVShowUseCase {
        return SaveTVShowUseCase(tvShowsRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteTVShowsUseCase(tvShowsRepository: TVShowsRepository): DeleteTVShowUseCase {
        return DeleteTVShowUseCase(tvShowsRepository)
    }
}