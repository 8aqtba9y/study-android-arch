package com.cosmospire.retrofittestapp

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApi {
    @GET("forecast/webservice/json/v1")
    fun getWhether(@Query("city") cityId: String): Single<WeatherResponse>

}