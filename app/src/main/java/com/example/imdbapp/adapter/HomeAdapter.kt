package com.example.imdbapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imdbapp.databinding.HomeItemBinding
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Search

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listImdb = emptyList<Search>()

    fun setListImdb(listImdb: List<Search>){

        this.listImdb = listImdb

    }

    class HomeViewHolder(private val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(search: Search){

            binding.LoadingImageView.load(search.Poster)
            binding.title.text = search.Title
            binding.type.text = search.Type
            binding.year.text = search.Year
            binding.imdbId.text = search.imdbID

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return  HomeViewHolder(HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val items = listImdb[position]

        if (position != null){

            holder.bind(items)
        }

    }

    override fun getItemCount(): Int {
        return listImdb.size
    }

}