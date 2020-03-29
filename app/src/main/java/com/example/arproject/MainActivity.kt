package com.example.arproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.arproject.databinding.ActivityMainBinding
import com.example.arproject.position.PositionViewModel

class MainActivity : AppCompatActivity() {
    val viewModel by lazy {
        ViewModelProvider(this).get(PositionViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}
