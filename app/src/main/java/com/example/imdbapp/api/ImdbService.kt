package com.example.imdbapp.api

import com.example.imdbapp.model.BatmanModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbService {

    @GET("?apikey=3e974fca&amp&s=batman")
    suspend fun getImdb(): Response<List<BatmanModel>>

    @GET("?apikey=3e974fca&amp&i={imdbID}")
    suspend fun getDetails(): Response<BatmanModel>


}