package com.amalwin.tmdbapplication.presentation.tvshows

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
import com.amalwin.tmdbapplication.databinding.ActivityMoviesBinding
import com.amalwin.tmdbapplication.databinding.ActivityTvshowsBinding
import com.amalwin.tmdbapplication.presentation.di.core.Injector
import javax.inject.Inject

class TVShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TVShowViewModelFactory
    private lateinit var binding: ActivityTvshowsBinding
    private lateinit var tvShowViewModel: TVShowViewModel

    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshows)
        (application as Injector).createTVShowSubComponent().inject(this)
        tvShowViewModel =
            ViewModelProvider(this, tvShowViewModelFactory).get(TVShowViewModel::class.java)
        initRecyclerView()
        //setContentView(R.layout.activity_tvshows)
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TVShowAdapter()
        binding.recyclerView.adapter = tvShowAdapter
        fetchTVShowsFromDataSource()
    }

    private fun fetchTVShowsFromDataSource() {
        binding.progressBar.visibility = View.VISIBLE
        tvShowViewModel.getTVShows().observe(this, Observer {
            if (it != null) {
                tvShowAdapter.setTVShowList(it)
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility = View.GONE
        })
    }

    private fun updateTVShowsFromDataSource() {
        Log.i("TVShows", "Update TV Shows!")
        binding.progressBar.visibility = View.VISIBLE
        tvShowViewModel.updateTVShows().observe(this, Observer {
            tvShowAdapter.setTVShowList(it)
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
                updateTVShowsFromDataSource()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}