package com.ibrahim.weatherapp.data.response

data class WeatherResponse(
    val current: Current?= Current(),
)

data class Current(
    val temp_c : Double ?= 0.0,
    val temp_f : Double ?= 0.0,
    val condition: Condition?= Condition(),
    val humidity  : Double ?= 0.0,
    val wind_kph  : Double ?= 0.0,
    val wind_degree  : Double ?= 0.0,
)

data class Condition(
    val text : String ?= "",
    val icon : String ?= ""
)

