package Data_Classes

data class WeatherResponse(
    val current_observation: CurrentObservation,
    val forecasts: List<Forecast>,
    val location: Location
)