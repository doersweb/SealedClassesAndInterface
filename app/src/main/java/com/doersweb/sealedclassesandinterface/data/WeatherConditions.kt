package com.doersweb.sealedclassesandinterface.data

sealed interface WeatherCondition {
    fun getConditions(): String
}

sealed class WeatherType: WeatherCondition {
    data class Sunny(val intensity: Int): WeatherType() {
        override fun getConditions(): String =  "Sunny weather with $intensity intensity"
    }

    data class Rainy(val intensity: Int): WeatherType() {
        override fun getConditions(): String =  "Rainy weather with $intensity intensity"
    }

    data class Cloudy(val coverage: String): WeatherType() {
        override fun getConditions(): String =  "Rainy weather with $coverage coverage"
    }
}