import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @Headers(
        "X-RapidAPI-Key: f83e5ea1d7msha20e7e40ba951f4p1df434jsndfe2568c12f5",
        "X-RapidAPI-Host: open-weather13.p.rapidapi.com"
    )
    @GET("city/{city}/EN")  // <-- Corrected URL format
    suspend fun getWeather(
        @Path("city") city: String
    ): WeatherResponse
    companion object{
        private const val BASE_URL = "https://open-weather13.p.rapidapi.com/"

        fun create():WeatherApi{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}