package com.example.animals.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.animals.adapter.AnimalAdapter
import com.example.animals.databinding.FragmentAnimalListBinding
import com.example.animals.network.ApiClient
import com.example.animals.viewmodel.AnimalListViewModel


class AnimalListFragment : Fragment() {
    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = AnimalListFragment()
    }

    private var adapter: AnimalAdapter? = null

    private val viewModel: AnimalListViewModel by lazy {
        ViewModelProvider(
            this,
            AnimalListViewModel.Provider(ApiClient.instance)
        ).get<AnimalListViewModel>(AnimalListViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AnimalAdapter()

        binding.animalList.adapter = adapter



        viewModel.fetchOfferList()

        viewModel.animalList.observe(viewLifecycleOwner){
            adapter?.submitList(it)

        }

        binding.searchBar.addTextChangedListener {
            val searchQuery = it.toString()

            if (searchQuery.isEmpty()) {
                viewModel.animalList.observe(viewLifecycleOwner){
                    adapter?.submitList(it)
                }
            } else {
                val filteredAnimals = viewModel.filterAnimals(searchQuery)

                adapter?.submitList(filteredAnimals)
            }
        }


    }




}