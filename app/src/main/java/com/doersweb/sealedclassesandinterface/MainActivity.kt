package com.doersweb.sealedclassesandinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doersweb.sealedclassesandinterface.data.Weather
import com.doersweb.sealedclassesandinterface.data.WeatherSource
import com.doersweb.sealedclassesandinterface.ui.theme.SealedClassesAndInterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SealedClassesAndInterfaceTheme {
                val locations = listOf("Delhi", "Bangalore", "Gurgaon", "Mumbai", "Hyderabad")
                val location = locations.random()
                val weather = WeatherSource.getWeather(location)
                setContent {
                    WeatherDisplay(weather = weather)
                }
            }
        }
    }
}

@Composable
fun WeatherDisplay(weather: Weather) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Location: ${weather.location}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Temperature: ${weather.temperature}°C",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Condition: ${weather.condition.getConditions()}",
            fontSize = 18.sp
        )
    }
}