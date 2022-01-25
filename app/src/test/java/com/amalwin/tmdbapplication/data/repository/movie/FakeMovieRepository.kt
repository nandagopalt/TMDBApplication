package com.amalwin.tmdbapplication.data.repository.movie

import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {
    private val moviesList = mutableListOf<Movie>()

    init {
        moviesList.add(Movie(1, "Overview 1", "posterPath1", "ReleaseDate1", "Title1"))
        moviesList.add(Movie(2, "Overview 2", "posterPath2", "ReleaseDate2", "Title2"))
        moviesList.add(Movie(3, "Overview 3", "posterPath3", "ReleaseData3", "Title3"))
    }

    override suspend fun getAllMovies(): List<Movie>? {
        return moviesList
    }

    override suspend fun deleteMovies() {
        moviesList.clear()
    }

    override suspend fun saveMovies(): List<Movie> {
        moviesList.add(Movie(4, "Overview 4", "posterPath4", "ReleaseDate4", "Title4"))
        moviesList.add(Movie(5, "Overview 5", "posterPath5", "ReleaseDate5", "Title5"))
        moviesList.add(Movie(6, "Overview 6", "posterPath6", "ReleaseData6", "Title6"))
        return moviesList
    }
}