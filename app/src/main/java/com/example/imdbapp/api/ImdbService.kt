package com.example.imdbapp.api

import retrofit2.http.GET

interface ImdbService {

    @GET("?apikey=3e974fca&amp&s=batman")
    suspend fun getImdb(){

    }

    @GET("?apikey=3e974fca&amp&i={imdbID}")
    suspend fun getDetails(){

    }


}