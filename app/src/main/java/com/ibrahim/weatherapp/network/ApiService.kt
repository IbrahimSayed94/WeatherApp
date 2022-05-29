package com.ibrahim.weatherapp.network

import com.ibrahim.weatherapp.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET
    suspend fun fetchWeatherBasedCity(
        @Query("q") city : String ?= "Dubai",
    ) : WeatherResponse
}