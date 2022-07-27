package com.example.imdbapp.api

import com.example.imdbapp.model.BatmanModel
import com.example.imdbapp.model.Details
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImdbService {

    @GET(".")
    suspend fun getImdb(
        @Query("apikey") apikey: String,
        @Query("s") imdb: String

    ): Response<BatmanModel>

    @GET(".")
    suspend fun getDetails(
        @Query("apikey") apikey: String,
        @Path("imdbID") id: String
    ): Response<Details>
}