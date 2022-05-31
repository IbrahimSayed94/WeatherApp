package com.ibrahim.weatherapp.data.repo

import android.util.Log
import com.ibrahim.weatherapp.base.BaseRepository
import com.ibrahim.weatherapp.data.response.WeatherResponse
import com.ibrahim.weatherapp.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository@Inject constructor(private val apiService: ApiService) : BaseRepository(apiService){

    private val TAG = "WeatherRepository"

    fun fetchWeatherBasedCity(city : String) : Flow<WeatherResponse> {
        return flow {
            val response = apiService.fetchWeatherBasedCity(city = city)
            Log.i(TAG,"fetchMainAlbums response $response")
            emit(response)
        }
    } // fun of fetchWeatherBasedCity
}