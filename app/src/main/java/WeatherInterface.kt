
import DataClasses.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherInterface {
    //Headers are the extra imformation that we want to provide and put in the
    @Headers(
        "X-RapidAPI-key:f83e5ea1d7msha20e7e40ba951f4p1df434jsndfe2568c12f5",
        "X-RapidAPI-Host:yahoo-weather5.p.rapidapi.com"
    )
    //Get to fetch data and weather is endpoint
    @GET("weather")
    suspend fun getWeather(
        //Query means add this piece of imformation to it
        @Query("location") location :String,
        @Query("format") format: String = "json",
        @Query("u") unit: String = "f"
    ): WeatherResponse
}