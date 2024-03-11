package com.example.dodosimplified

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodosimplified.R
import com.example.dodosimplified.databinding.ActivityProductBinding
import com.example.dodosimplified.model.Dodster
import com.example.dodosimplified.model.Pizza
import com.example.dodosimplified.model.PizzaCombo

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = intent.getSerializableExtra("Pizza") as? Pizza
        val combo = intent.getSerializableExtra("Combo") as? PizzaCombo
        val dodster = intent.getSerializableExtra("Dodster") as? Dodster

        when {
            pizza!=null->

            with(binding) {
                productImage.setImageResource(pizza.imageRes)
                title.text = pizza.title
                description.text = pizza.description
                price.text = "от ${pizza.price} KZT"
                size.text = "${pizza.size} см"
            }
            dodster!=null->

                with(binding) {
                    productImage.setImageResource(dodster.imageRes)
                    title.text = dodster.title
                    description.text = dodster.description
                    price.text = "от ${dodster.price} KZT"
                    size.text = "${dodster.weight} гр"
                }
            combo!=null->

                with(binding) {
                    productImage.setImageResource(combo.imageRes)
                    title.text = combo.title
                    description.text = combo.description
                    price.text = "от ${combo.price} KZT"
                    size.text = "${combo.size} см"
                }
        }
        binding.returnButton.setOnClickListener{
            onBackPressed();
        }
    }
}