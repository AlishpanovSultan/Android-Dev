package com.example.midkaprep.network

import com.example.midkaprep.model.Car
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface CarService {
    @GET("cars.json")
    fun fetchCarList(): Call<ArrayList<Car>>


}