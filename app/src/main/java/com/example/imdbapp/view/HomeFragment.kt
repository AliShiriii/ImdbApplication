package com.example.imdbapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbapp.R
import com.example.imdbapp.adapter.HomeAdapter
import com.example.imdbapp.databinding.FragmentHomeBinding
import com.example.imdbapp.viewModel.DetailsViewModel
import com.example.imdbapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter

    private val homeFragmentViewModel: HomeViewModel by viewModels()
    private val detailsViewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUserInterface()
        observeImdbList()
    }

    private fun initUserInterface() {
        initRecyclerView()
    }

    private fun initRecyclerView() {

        homeAdapter = HomeAdapter(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = homeAdapter

    }

    private fun observeImdbList() {

        homeFragmentViewModel.getImdb()
        homeFragmentViewModel.batmanImdb.observe(viewLifecycleOwner) { response ->

            homeAdapter.setListImdb(response.Search.toMutableList())

        }

    }

    override fun onItemClick(id: String) {

        detailsViewModel.getDetails(id)

        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
        findNavController().navigate(action)

    }


}