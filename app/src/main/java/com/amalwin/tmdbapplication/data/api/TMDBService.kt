package com.amalwin.tmdbapplication.data.api

import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.data.model.actor.ActorList
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.data.model.movie.MovieList
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import com.amalwin.tmdbapplication.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String,
                                  @Query("language") language: String,
                                  @Query("page") page: Int): Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularActors(@Query("api_key") apiKey: String,
                                 @Query("language") language: String,
                                 @Query("page") page: Int): Response<ActorList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String,
                                  @Query("langauge") language: String,
                                    @Query("page") page:Int): Response<TVShowList>
}