package com.example.imdbapp.repository

import com.example.imdbapp.api.ImdbService
import com.example.imdbapp.model.Details
import com.example.imdbapp.model.Search
import com.example.imdbapp.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val imdbService: ImdbService) {

    suspend fun getDetails(imdbId: String): Response<Details> =
        imdbService.getDetails(apikey = Constants.API_KEY, id = imdbId)

}