package com.example.imdbapp.api

import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbService {

    @GET(".")
    suspend fun getImdb(
        @Query("apikey") apikey: String,
        @Query("s") imdb: String

    ): Response<BatmanModel>

}