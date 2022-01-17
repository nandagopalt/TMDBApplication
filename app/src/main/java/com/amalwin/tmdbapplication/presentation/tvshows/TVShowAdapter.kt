package com.amalwin.tmdbapplication.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amalwin.tmdbapplication.BuildConfig
import com.amalwin.tmdbapplication.R
import com.amalwin.tmdbapplication.data.model.tvshow.TVShow
import com.amalwin.tmdbapplication.data.model.tvshow.TVShowList
import com.amalwin.tmdbapplication.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TVShowAdapter constructor() : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private val tvShowList = ArrayList<TVShow>()
    private lateinit var binding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(tvShowViewHolder: TVShowViewHolder, position: Int) {
        tvShowViewHolder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    fun setTVShowList(tvShowList: List<TVShow>) {
        this.tvShowList.clear()
        this.tvShowList.addAll(tvShowList)
        notifyDataSetChanged()
    }

    class TVShowViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShow) {
            binding.txtViewTile.text = tvShow.name
            binding.txtViewDescription.text = tvShow.overview
            val imagePosterURL = BuildConfig.IMAGE_BASE_URL + tvShow.posterPath
            Glide.with(binding.imgView.context).load(imagePosterURL).into(binding.imgView)
        }
    }
}