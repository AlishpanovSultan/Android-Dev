package com.example.animals.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animals.databinding.AnimalItemBinding
import com.example.animals.model.Animal


class AnimalAdapter() : ListAdapter<Animal, AnimalAdapter.ViewHolder>(AnimalDiffUtil()) {

    /**
     * метод, который будет создавать view для каждого объекта
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AnimalItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    /**
     * для вызова метода из ViewHolder'a
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: AnimalItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: Animal) {
            val characteristic =animal.characteristics

            with(binding) {
                animalName.text = animal.name
                animalDescription.text = characteristic.color +'\n' + characteristic.diet + characteristic.lifespan+animal.locations.toString()

            }
        }
    }
}