package com.example.midkaprep.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midkaprep.adapter.CarAdapter
import com.example.midkaprep.databinding.FragmentCarListBinding
import com.example.midkaprep.model.Car
import com.example.midkaprep.network.ApiClient

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class CarListFragment : Fragment() {

    private var _binding: FragmentCarListBinding? = null
    private val binding get() = _binding!!
    private val client = ApiClient.instance
    private var adapter: CarAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CarAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        getCars()
    }
    private fun getCars() {
        val response = client.fetchCarList()
        response.enqueue(object : Callback<ArrayList<Car>>{
            override fun onResponse(call: Call<ArrayList<Car>>, response: Response<ArrayList<Car>>) {
                val cars = response.body()
                println("HttpResponse: ${response.body()}")
                if (cars != null) {
                    adapter?.setSections(cars)
                }
            }

            override fun onFailure(call: Call<ArrayList<Car>>, t: Throwable) {
                println("HttpResponse: ${t.message}")
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    companion object{
//        @JvmStatic
//        fun newInstance() = CarListFragment()
//    }

}