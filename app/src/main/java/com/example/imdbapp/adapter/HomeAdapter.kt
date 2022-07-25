package com.example.imdbapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbapp.databinding.HomeItemBinding
import com.example.imdbapp.model.BatmanModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listImdb = emptyList<BatmanModel>()

    fun setListImdb(listImdb: List<BatmanModel>){

        this.listImdb = listImdb

    }

    class HomeViewHolder(private val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(search: BatmanModel){

            binding.title.text = search.Search[adapterPosition].Title
            binding.type.text = search.Search[adapterPosition].Type
            binding.year.text = search.Search[adapterPosition].Year
            binding.imdbId.text = search.Search[adapterPosition].imdbID

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