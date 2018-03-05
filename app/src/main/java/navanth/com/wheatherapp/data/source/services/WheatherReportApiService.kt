package navanth.com.wheatherapp.data.source.services

import io.reactivex.Observable
import navanth.com.wheatherapp.data.entity.WheatherResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WheatherReportApiService {

    @GET("forecast/daily")
    fun getWheatherReportBasedOnCityName(
            @Query("q") cityName: String,
            @Query("cnt") days: String,
            @Query("appid") apiKey: String): Observable<WheatherResponse>

    @GET("forecast/daily")
    fun getWheatherReportBasedOnLatLong(
            @Query("lat") lat: String,
            @Query("lon") long: String,
            @Query("cnt") days: String,
            @Query("appid") apiKey: String): Observable<WheatherResponse>
}