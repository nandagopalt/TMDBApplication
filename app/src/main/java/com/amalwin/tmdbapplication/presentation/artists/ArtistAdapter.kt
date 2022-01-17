package com.amalwin.tmdbapplication.presentation.artists

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbapplication.BuildConfig
import com.amalwin.tmdbapplication.R
import com.amalwin.tmdbapplication.data.model.actor.Actor
import com.amalwin.tmdbapplication.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    private val artistList = ArrayList<Actor>()
    private lateinit var binding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(artistViewHolder: ArtistViewHolder, position: Int) {
        artistViewHolder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    fun setArtistList(artistList: List<Actor>) {
        this.artistList.clear()
        this.artistList.addAll(artistList)
        notifyDataSetChanged()
    }

    class ArtistViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Actor) {
            binding.txtViewTile.text = artist.name
            binding.txtViewDescription.text = artist.popularity.toString()
            val imageURL = BuildConfig.IMAGE_BASE_URL + artist.profilePath
            //Log.i("Image", "URL: $imageURL")
            Glide.with(binding.imgView.context).load(imageURL)
                .into(binding.imgView)
        }
    }
}