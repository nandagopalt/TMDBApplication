package com.amalwin.tmdbapplication.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalwin.tmdbapplication.R
import com.amalwin.tmdbapplication.databinding.ActivityArtistsBinding
import com.amalwin.tmdbapplication.presentation.di.core.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {

    @Inject
    lateinit var artistsViewModelFactory: ArtistsViewModelFactory
    private lateinit var binding: ActivityArtistsBinding

    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var artistsAdapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
        (application as Injector).createArtistSubComponent().inject(this)
        artistsViewModel =
            ViewModelProvider(this, artistsViewModelFactory).get(ArtistsViewModel::class.java)
        initRecyclerView()
        //setContentView(R.layout.activity_artists)
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        artistsAdapter = ArtistAdapter()
        binding.recyclerView.adapter = artistsAdapter
        fetchArtistsFromDataSource()
    }

    private fun fetchArtistsFromDataSource() {
        binding.progressBar.visibility = View.VISIBLE
        artistsViewModel.getArtists().observe(this, Observer {
            Log.i("Artists", it.toString())
            if (it != null) {
                artistsAdapter.setArtistList(it)
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility = View.GONE
        })
    }

    private fun updateArtistsFromDataSource() {
        Log.i("Artist", "Update the artist !")
        binding.progressBar.visibility = View.VISIBLE
        artistsViewModel.updateArtists().observe(this, Observer {
            artistsAdapter.setArtistList(it)
        })
        binding.progressBar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.update -> {
                updateArtistsFromDataSource()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}