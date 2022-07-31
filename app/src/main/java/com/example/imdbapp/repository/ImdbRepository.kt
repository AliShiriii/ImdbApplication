package com.example.imdbapp.repository

import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import retrofit2.Response

interface ImdbRepository {

    suspend fun getImdb(): Response<BatmanModel>

    suspend fun getDetails(imdbId: String): Response<Details>
}