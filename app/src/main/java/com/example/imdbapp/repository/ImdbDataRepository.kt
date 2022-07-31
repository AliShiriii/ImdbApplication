package com.example.imdbapp.repository

import com.example.imdbapp.api.ImdbService
import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import com.example.imdbapp.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class ImdbDataRepository @Inject constructor(private val imdbService: ImdbService) :
    ImdbRepository {

    override suspend fun getImdb(): Response<BatmanModel> =
        imdbService.getImdb(apikey = Constants.API_KEY, imdb = "batman")

    override suspend fun getDetails(imdbId: String): Response<Details> =
        imdbService.getDetails(apikey = Constants.API_KEY, id = imdbId)


}