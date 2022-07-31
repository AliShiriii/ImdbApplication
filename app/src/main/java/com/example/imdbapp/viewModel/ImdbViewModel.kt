package com.example.imdbapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import com.example.imdbapp.repository.ImdbDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImdbViewModel @Inject constructor(private val imdbDataRepository: ImdbDataRepository) : ViewModel() {

    private val _batmanImdb = MutableLiveData<BatmanModel>()
    val batmanImdb: LiveData<BatmanModel> = _batmanImdb

    private val _details = MutableLiveData<Details>()
    val details: LiveData<Details> = _details

    fun getImdb() = viewModelScope.launch {

            val response = imdbDataRepository.getImdb()

                _batmanImdb.value = response.body()

    }

    fun getDetails(imdbId: String) = viewModelScope.launch {

        val details = imdbDataRepository.getDetails(imdbId)

        if (details.isSuccessful) {
            _details.value = details.body()
        }
    }
}