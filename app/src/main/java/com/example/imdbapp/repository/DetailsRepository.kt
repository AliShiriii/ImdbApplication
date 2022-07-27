package com.example.imdbapp.repository

import com.example.imdbapp.api.ImdbService
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import com.example.imdbapp.model.Search
import com.example.imdbapp.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val imdbService: ImdbService, private val search: Search) {

    suspend fun getDetails(): Response<Details> = imdbService.getDetails(apikey = Constants.API_KEY, search.imdbID)

}