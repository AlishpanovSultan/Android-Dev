package com.example.midkaprep.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midkaprep.R
import com.example.midkaprep.databinding.ItemCarBinding
import com.example.midkaprep.model.Car


class CarAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val cars: ArrayList<Car> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CarViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CarViewHolder -> holder.bind(cars[position])
        }
    }

    fun setSections(cars: ArrayList<Car>) {
        this.cars.clear()
        this.cars.addAll(cars)
        notifyDataSetChanged()
    }

    private inner class CarViewHolder(
        private val binding: ItemCarBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            with (binding) {
                Glide
                    .with(root.context)
                    .load(car.img)
                    .placeholder(R.drawable.baseline_car_crash_24)
                    .into(carPhoto)

                carTitle.text = car.manufacturer+' ' + car.model
                carPrice.text = car.price.toString()
                carDescription.text = car.wiki


            }
        }
    }

}