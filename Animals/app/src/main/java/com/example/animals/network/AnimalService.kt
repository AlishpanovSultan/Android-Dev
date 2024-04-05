package com.example.animals.network
import com.example.animals.model.Animal
import retrofit2.Call
import retrofit2.http.GET

interface AnimalService {

    @GET("animals?name=all")
    fun fetchAnimalList(): Call<List<Animal>>
}