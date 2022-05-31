package com.ibrahim.weatherapp.base

import androidx.lifecycle.ViewModel
import com.ibrahim.weatherapp.network.ErrorManager

abstract class BaseViewModel(private val repository: BaseRepository) : ViewModel() {
    fun getStatusCode(throwable: Throwable) : Int
    {
        return ErrorManager.getCode(throwable = throwable)
    } // fun of getStatusCode
}