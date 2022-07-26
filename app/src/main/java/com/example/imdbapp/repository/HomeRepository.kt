package com.example.imdbapp.repository

import com.example.imdbapp.api.ImdbService
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Search
import com.example.imdbapp.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val imdbService: ImdbService) {

    suspend fun getImdb(): Response<BatmanModel>{

        return imdbService.getImdb(apikey = Constants.API_KEY, imdb = "batman")

    }


}