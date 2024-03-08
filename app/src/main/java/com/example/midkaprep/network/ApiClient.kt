package com.example.midkaprep.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/shuvam07/CarDekho/master/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance: CarService = retrofit.create(CarService::class.java)
}