package com.amalwin.tmdbapplication.data.repository.movie.datasourceimpl

import com.amalwin.tmdbapplication.data.db.MovieDAO
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl constructor(private val movieDAO: MovieDAO): MovieLocalDataSource {
    override suspend fun getPopularMoviesFromDB(): List<Movie> = movieDAO.getAllMovies()

    override suspend fun savePopularMoviesToDB(moviesList: List<Movie>)  {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(moviesList)
        }
    }

    override suspend fun deletePopularMoviesFromDB()  {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}