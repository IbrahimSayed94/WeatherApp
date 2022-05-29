package com.ibrahim.weatherapp.data

data class WeatherResponse(
    val current: Current ?= Current(),
    val humidity  : Double ?= 0.0,
    val wind_kph  : Double ?= 0.0,
    val wind_degree  : Double ?= 0.0,
)

data class Current(
    val temp_c : Double ?= 0.0,
    val temp_f : Double ?= 0.0,
    val condition: Condition ?= Condition()
)

data class Condition(
    val text : String ?= "",
    val icon : String ?= ""
)