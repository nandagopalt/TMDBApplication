package com.amalwin.tmdbapplication.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbapplication.R
import com.amalwin.tmdbapplication.data.model.movie.Movie
import com.amalwin.tmdbapplication.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setMoviesList(moviesList: List<Movie>) {
        this.movieList.clear()
        this.movieList.addAll(moviesList)
    }

    class MovieViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.txtViewTile.text = movie.title
            binding.txtViewDescription.text = movie.overview
            val imagePosterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterPath
            Glide.with(binding.imgView.context).load(imagePosterURL).into(binding.imgView)
        }
    }
}