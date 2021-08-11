package com.example.mistplaychallenge

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mistplaychallenge.adapters.MainModelAdapter
import com.example.mistplaychallenge.databinding.ActivityMainBinding
import com.example.mistplaychallenge.viewmodels.MainViewModel

/**
 * Entry activity for application
 * @author Nav Singh
 */
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        // observe the data reading, update the UI based on it's state
        mainViewModel.jsonModelData.observe(this) {
            it?.let {
                binding.listDataHolder.adapter = MainModelAdapter(it)
            }
        }
    }
}
