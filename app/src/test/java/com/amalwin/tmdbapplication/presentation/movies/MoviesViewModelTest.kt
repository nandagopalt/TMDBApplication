package com.amalwin.tmdbapplication.presentation.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.repository.movie.FakeMovieRepository
import com.amalwin.tmdbapplication.domain.usecase.DeleteMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.GetMoviesUseCase
import com.amalwin.tmdbapplication.domain.usecase.SaveMoviesUseCase
import com.anushka.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesViewModelTest {
    private lateinit var movieViewModel: MoviesViewModel

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val movieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(movieRepository)
        val deleteMoviesUseCase = DeleteMoviesUseCase(movieRepository)
        val saveMoviesUseCase = SaveMoviesUseCase(movieRepository)
        movieViewModel = MoviesViewModel(getMoviesUseCase, saveMoviesUseCase, deleteMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentMoviesList() {
        val moviesList = mutableListOf<Movie>()
        moviesList.add(Movie(1, "Overview 1", "posterPath1", "ReleaseDate1", "Title1"))
        moviesList.add(Movie(2, "Overview 2", "posterPath2", "ReleaseDate2", "Title2"))
        moviesList.add(Movie(3, "Overview 3", "posterPath3", "ReleaseData3", "Title3"))
        val movies = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(movies).isEqualTo(moviesList)
    }

    @Test
    fun updateMovies_returnsUpdatedMoviesList() {
        val moviesList = mutableListOf<Movie>()
        moviesList.add(Movie(4, "Overview 4", "posterPath4", "ReleaseDate4", "Title4"))
        moviesList.add(Movie(5, "Overview 5", "posterPath5", "ReleaseDate5", "Title5"))
        moviesList.add(Movie(6, "Overview 6", "posterPath6", "ReleaseData6", "Title6"))
        val movies = movieViewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(movies).isEqualTo(moviesList)
    }
}