package com.example.midkaprep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.midkaprep.databinding.ActivityMainBinding
import com.example.midkaprep.fragment.CarListFragment
import com.example.midkaprep.fragment.FavoritiesFragment
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.setOnItemSelectedListener(this)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, CarListFragment())
            .commit()
        binding.fragmentContainer
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = when(item.itemId){
            R.id.favorities -> FavoritiesFragment()
            else -> CarListFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
        return true
    }

}