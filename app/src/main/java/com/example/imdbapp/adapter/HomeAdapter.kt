package com.example.imdbapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imdbapp.databinding.HomeItemBinding
import com.example.imdbapp.model.Search

class HomeAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    interface OnItemClickListener {

        fun onItemClick(id: String)

    }

    private var listImdb = emptyList<Search>()

    fun setListImdb(listImdb: MutableList<Search>) {

        this.listImdb = listImdb
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(search: Search) {

            binding.LoadingImageView.load(search.Poster)
            binding.title.text = search.Title
            binding.type.text = search.Type
            binding.year.text = search.Year
            binding.imdbId.text = search.imdbID

            itemView.rootView.setOnClickListener {

                listener.onItemClick(search.imdbID)


            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val items = listImdb[position]

        if (position != null) {

            holder.bind(items)
        }

    }

    override fun getItemCount(): Int {
        return listImdb.size
    }

}