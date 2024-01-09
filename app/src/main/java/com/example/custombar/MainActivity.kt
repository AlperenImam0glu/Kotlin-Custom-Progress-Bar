package com.example.custombar

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.custombar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding
    lateinit  var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rv.layoutManager = layoutManager
        adapter = MyAdapter(20,5)
        binding.rv.adapter = adapter


        setContentView(binding.root)


    }

}