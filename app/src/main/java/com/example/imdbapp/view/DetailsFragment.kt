package com.example.imdbapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.imdbapp.R
import com.example.imdbapp.databinding.FragmentDetailsBinding
import com.example.imdbapp.viewModel.ImdbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ImdbViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetails()

    }

    private fun observeDetails(){

        viewModel.details.observe(viewLifecycleOwner){ details ->

            binding.imageDetails.load(details.Poster)

            binding.detailsYear.text = details.Year
            binding.detailsRated.text = details.Rated
            binding.detailsReleased.text = details.Released
            binding.detailsRuntime.text = details.Runtime
            binding.detailsGenre.text = details.Genre
            binding.detailsDirector.text = details.Director
            binding.detailsWriter.text = details.Writer
            binding.detailsActors.text = details.Actors

        }

    }
}