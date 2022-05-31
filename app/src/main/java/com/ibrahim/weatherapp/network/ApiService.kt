package com.ibrahim.weatherapp.network

import com.ibrahim.weatherapp.data.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.getWeatherBasedCity)
    suspend fun fetchWeatherBasedCity(
        @Query("q") city : String ?= "Dubai",
        @Query("days") days : Int ?= 5,
        @Query("aqi") aqi : String ?= "no",
        @Query("alerts") alerts : String ?= "no",
    ) : WeatherResponse
}