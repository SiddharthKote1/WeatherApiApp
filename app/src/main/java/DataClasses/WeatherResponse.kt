package DataClasses

data class WeatherResponse(
    val current_observation: CurrentObservation,
    val forecasts: List<Forecast>,
    val location: Location
)

data class Location(
    val city: String,
    val country: String,
    val lat: Double,
    val long: Double,
    val timezone_id: String,
    val woeid: Int
)

data class Wind(
    val chill: Int,
    val direction: String,
    val speed: Int
)

data class Forecast(
    val code: Int,
    val date: Int,
    val day: String,
    val high: Int,
    val low: Int,
    val text: String
)

data class CurrentObservation(
    val astronomy: Astronomy,
    val atmosphere: Atmosphere,
    val condition: Condition,
    val pubDate: Int,
    val wind: Wind
)

data class Condition(
    val code: Int,
    val temperature: Int,
    val text: String
)

data class Atmosphere(
    val humidity: Int,
    val pressure: Double,
    val visibility: Int
)

data class Astronomy(
    val sunrise: String,
    val sunset: String
)