package com.example.animals.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animals.model.Animal
import com.example.animals.network.AnimalService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalListViewModel(
    private val service: AnimalService
) : ViewModel() {

    class Provider(
        val service: AnimalService
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AnimalListViewModel(service) as T
        }
    }

    fun filterAnimals(query: String?): List<Animal> {
        // Filter the original list of animals based on the search query
        return _animalList.value?.filter { animal ->
            animal.name.contains(query.orEmpty(), ignoreCase = true)
        } ?: emptyList()
    }

    private val _animalList = MutableLiveData<ArrayList<Animal>>(arrayListOf())
    val animalList: LiveData<ArrayList<Animal>> get() = _animalList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchOfferList() {

        service.fetchAnimalList().enqueue(object : Callback<List<Animal>> {
            override fun onResponse(
                call: Call<List<Animal>>,
                response: Response<List<Animal>>
            ) {

                if (response.isSuccessful) {
                    _animalList.value = ArrayList(response.body() ?: emptyList())
                } else {
                    _error.value = "Failed to fetch data: ${response.message()}"
                }

            }
            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                _error.value = "Network Error: ${t.message}"
            }

        })
    }
}