package com.example.animals.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.animals.model.Animal

class AnimalDiffUtil : DiffUtil.ItemCallback<Animal>() {
    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem == newItem
    }

}