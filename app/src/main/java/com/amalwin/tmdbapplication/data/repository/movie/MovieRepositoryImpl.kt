package com.amalwin.tmdbapplication.data.repository.movie

import android.util.Log
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieCacheDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieLocalDataSource
import com.amalwin.tmdbapplication.data.repository.movie.datasource.MovieRemoteDataSource
import com.amalwin.tmdbapplication.domain.repository.MovieRepository

class MovieRepositoryImpl constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getAllMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun deleteMovies() {
       movieLocalDataSource.deletePopularMoviesFromDB()
    }

    override suspend fun saveMovies(): List<Movie> {
        val movies = getMoviesFromAPI()
        deleteMovies()
        movieLocalDataSource.savePopularMoviesToDB(movies)
        movieCacheDataSource.savePopularMoviesToCache(movies)
        return movies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            body.let {
                movies = it?.movies!!
            }
        } catch (exception: Exception) {
            Log.i("Exception", exception.message.toString())
        }
        return movies
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movies: List<Movie>
         try {
             movies = movieLocalDataSource.getPopularMoviesFromDB()
         } catch(exception: Exception) {
             Log.i("Exception", exception.message.toString())
         }
        if(movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromAPI()
            movieLocalDataSource.savePopularMoviesToDB(movies)
        }
       return movies
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            movies = movieCacheDataSource.getPopularMoviesFromCache()
        } catch(exception: Exception){
            Log.i("Exception", exception.message.toString())
        }
        if(movies.isNotEmpty()) {
            return movies
        } else {
            movies = getMoviesFromDB()
            movieCacheDataSource.savePopularMoviesToCache(movies)
        }
        return movies
    }

}