package com.doersweb.sealedclassesandinterface.data

object WeatherSource {
    fun getWeather(location: String): Weather {
        val condition = when ((0..2).random()) {
            0 -> WeatherType.Sunny((1..10).random())
            1 -> WeatherType.Rainy((1..10).random())
            else -> WeatherType.Cloudy("Partly")
        }

        return Weather(location, generateTemperature(), condition)
    }

    private fun generateTemperature(): Double {
        return (Math.random() * 50)
    }
}