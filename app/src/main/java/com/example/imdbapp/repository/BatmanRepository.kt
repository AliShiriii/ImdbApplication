package com.example.imdbapp.repository

import com.example.imdbapp.api.ImdbService
import com.example.imdbapp.model.BatmanModel
import retrofit2.Response
import javax.inject.Inject

class BatmanRepository @Inject constructor(private val imdbService: ImdbService) {

    suspend fun getImdb(): Response<List<BatmanModel>>{

        return imdbService.getImdb()

    }

    suspend fun getDetails(): Response<BatmanModel> {

        return imdbService.getDetails()

    }

}