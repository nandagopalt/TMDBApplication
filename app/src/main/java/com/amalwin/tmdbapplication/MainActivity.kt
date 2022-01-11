package com.amalwin.tmdbapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amalwin.tmdbapplication.databinding.ActivityMainBinding
import com.amalwin.tmdbapplication.presentation.artists.ArtistsActivity
import com.amalwin.tmdbapplication.presentation.di.core.Injector
import com.amalwin.tmdbapplication.presentation.movies.MoviesActivity
import com.amalwin.tmdbapplication.presentation.tvshows.TVShowsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }
        binding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
        binding.tvshowButton.setOnClickListener {
            val intent = Intent(this, TVShowsActivity::class.java)
            startActivity(intent)
        }


        //setContentView(R.layout.activity_main)
    }
}