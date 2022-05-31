package com.ibrahim.weatherapp.ui.weather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahim.weatherapp.base.BaseViewModel
import com.ibrahim.weatherapp.data.response.WeatherResponse
import com.ibrahim.weatherapp.data.repo.WeatherRepository
import com.ibrahim.weatherapp.network.ResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel@Inject constructor(private val repository: WeatherRepository) : BaseViewModel(repository) {

    private val TAG = "WeatherViewModel"

    private val _weatherDataObserver = MutableLiveData<ResultModel<WeatherResponse>>()
    val weatherDataObserver: LiveData<ResultModel<WeatherResponse>> = _weatherDataObserver


    fun fetchTeamMainData(city : String)
    {
        _weatherDataObserver.postValue(ResultModel.Loading(isLoading = true))
        viewModelScope.launch {
            repository.fetchWeatherBasedCity(city = city)
                .catch { exception ->
                    Log.i(TAG,"Exception : ${exception.message}")
                    _weatherDataObserver.value = ResultModel.Failure(code = getStatusCode(throwable = exception))
                    _weatherDataObserver.postValue(ResultModel.Loading(isLoading = false))
                } // exception
                .collect { response ->
                    Log.i(TAG,"Response : $response")
                    _weatherDataObserver.postValue(ResultModel.Success(data = response))
                } // collect
        }
    } // fun of fetchTeamMainData

} // class of WeatherViewModel