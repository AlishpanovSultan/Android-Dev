package com.example.dodosimplified.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodosimplified.databinding.ItemComboBinding
import com.example.dodosimplified.databinding.ItemPizzaBinding
import com.example.dodosimplified.model.*


class PizzaAdapter(private var onItemClick: (Menu) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val menu: ArrayList<Menu> = ArrayList()

    fun setMenu(newList: ArrayList<Menu>) {
        menu.clear()
        menu.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return menu[position].getItemListType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Menu.Type.Pizza.ordinal -> {
                return PizzaViewHolder(
                    ItemPizzaBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            Menu.Type.Combo.ordinal -> {
                return PizzaComboViewHolder(
                    ItemComboBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            Menu.Type.Dodster.ordinal -> {
                return DodsterViewHolder(
                    ItemComboBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return PizzaViewHolder(
                    ItemPizzaBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val product = menu[position]
        when (holder) {
            is PizzaViewHolder -> if(product is Pizza) holder.bind(product)
            is DodsterViewHolder -> if(product is Dodster) holder.bind(product)
            is PizzaComboViewHolder -> if(product is PizzaCombo) holder.bind(product)
        }
    }

    inner class PizzaViewHolder(
        private val binding: ItemPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            with(binding) {
                pizzaImage.setImageResource(pizza.imageRes)
                title.text = pizza.title
                description.text = pizza.description
                price.text = "${pizza.price} KZT"
                size.text = "${pizza.size} см"
                root.setOnClickListener {
                    onItemClick(pizza)
                }
            }
        }
    }

    inner class PizzaComboViewHolder(
        private val binding: ItemComboBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(combo: PizzaCombo) {
            with(binding) {
                comboImage.setImageResource(combo.imageRes)
                comboTitle.text = combo.title
                comboDescription.text = combo.description
                price.text = "${combo.price} KZT"
                comboSize.text = "${combo.size} см"
                root.setOnClickListener {
                    onItemClick(combo)
                }
            }
        }
    }

    inner class DodsterViewHolder(
        private val binding: ItemComboBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dodster: Dodster) {
            with(binding) {
                comboImage.setImageResource(dodster.imageRes)
                comboTitle.text = dodster.title
                comboDescription.text = dodster.description
                price.text = "${dodster.price} KZT"
                comboSize.text = "${dodster.weight} гр"
                root.setOnClickListener {
                    onItemClick(dodster)
                }
            }
        }
    }
}