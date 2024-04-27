package com.doersweb.sealedclassesandinterface.data

data class Weather(
    val location: String,
    val temperature: Double,
    val condition: WeatherType
) : WeatherCondition by condition
