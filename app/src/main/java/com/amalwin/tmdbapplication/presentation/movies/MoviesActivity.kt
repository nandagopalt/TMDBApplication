package com.amalwin.tmdbapplication.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amalwin.tmdbapplication.R
import com.amalwin.tmdbapplication.databinding.ActivityMoviesBinding
import com.amalwin.tmdbapplication.presentation.App
import com.amalwin.tmdbapplication.presentation.di.core.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MoviesViewModel
    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
        (application as Injector).createMovieSubComponent().inject(this)
        //setContentView(R.layout.activity_movies)
        movieViewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MyTag", it.toString())
        })
    }
}