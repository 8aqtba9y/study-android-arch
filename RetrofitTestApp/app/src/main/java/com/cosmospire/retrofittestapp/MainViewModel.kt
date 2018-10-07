package com.cosmospire.retrofittestapp

import android.arch.lifecycle.ViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel: ViewModel() {

    var whether = Retrofit.Builder()
            .baseUrl("http://weather.livedoor.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(IWeatherApi::class.java).getWhether("200010")

    override fun onCleared() {
        super.onCleared()
    }
}