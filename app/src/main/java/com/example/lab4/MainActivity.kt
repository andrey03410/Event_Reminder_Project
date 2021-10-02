package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lab4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setupBottomNavigationBar()
        setContentView(binding.root)
    }
    private fun setupBottomNavigationBar() {
        binding.botNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_events -> {openFragment(EventsFragment())
                    true}
                R.id.menu_holidays -> {openFragment(HolidaysFragment())
                    true}
                R.id.menu_profile -> {openFragment(ProfileFragment())
                    true}
                else -> true
            }
        }
    }
    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_home, fragment)
            .addToBackStack(null)
            .commit()
    }
}