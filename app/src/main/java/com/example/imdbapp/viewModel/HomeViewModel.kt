package com.example.imdbapp.viewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Search
import com.example.imdbapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {


    private val _batmanImdb = MutableLiveData<BatmanModel>()
    val batmanImdb: LiveData<BatmanModel> = _batmanImdb

    fun getImdb() {

        viewModelScope.launch {
            val response = homeRepository.getImdb()

                _batmanImdb.value = response.body()

        }
    }
}