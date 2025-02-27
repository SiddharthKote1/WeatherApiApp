package viewmodel

import WeatherInterface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import DataClasses.WeatherResponse
import repository.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> = _weatherData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchWeather(location: String, unit: String = "f") {
        viewModelScope.launch {
            try {
                val response = repository.getWeather(location, unit)
                _weatherData.postValue(response)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}
