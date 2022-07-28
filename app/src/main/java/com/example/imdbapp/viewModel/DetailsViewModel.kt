package com.example.imdbapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import com.example.imdbapp.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository): ViewModel() {

    private val _details = MutableLiveData<Details>()
    val details: LiveData<Details> = _details

    fun getDetails(imdbId: String) = viewModelScope.launch {

        val details = detailsRepository.getDetails(imdbId)

        _details.value = details.body()

    }

}