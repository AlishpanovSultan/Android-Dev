package com.example.dodosimplified

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dodosimplified.adapter.PizzaAdapter
import com.example.dodosimplified.databinding.ActivityMainBinding
import com.example.dodosimplified.model.*

class MainActivity : AppCompatActivity() {

    private val menu = MenuDataSource.menuList

    private var adapter : PizzaAdapter?=null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener{
            handleSearchButtonClick()
        }

        adapter = PizzaAdapter(

            onItemClick = {
                if(it is Pizza)
                    handlePizzaClick(it)
                else if(it is PizzaCombo)
                    handleComboClick(it)
                else if (it is Dodster)
                    handleDodsterClick(it)
            }
        )

        binding.recyclerView.adapter = adapter
        adapter?.setMenu(menu)



    }
    private fun handlePizzaClick(pizza: Pizza) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("Pizza", pizza)
        startActivity(intent)
    }
    private fun handleComboClick(combo: PizzaCombo) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("Combo", combo)
        startActivity(intent)
    }
    private fun handleDodsterClick(dodster: Dodster) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("Dodster", dodster)
        startActivity(intent)
    }
    private fun handleSearchButtonClick() {
        val text = binding.searchBar.text.toString()
        if (!text.isEmpty()) {
            val newSections = menu.filter { it.title.lowercase().contains(text.lowercase()) }
            adapter?.setMenu(ArrayList(newSections))
        } else {
            adapter?.setMenu(menu)
        }
    }

}