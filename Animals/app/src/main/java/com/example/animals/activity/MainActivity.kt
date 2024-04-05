package com.example.animals.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animals.R
import com.example.animals.databinding.ActivityMainBinding
import com.example.animals.fragment.AnimalListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, AnimalListFragment.newInstance())
            .commit()

    }
}