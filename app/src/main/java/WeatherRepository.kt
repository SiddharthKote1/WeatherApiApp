package repository

import DataClasses.WeatherResponse
import WeatherInterface

class WeatherRepository(private val api: WeatherInterface) {
    suspend fun getWeather(location: String, unit: String = "f"): WeatherResponse {
        return api.getWeather(location, unit = unit)
    }
}
