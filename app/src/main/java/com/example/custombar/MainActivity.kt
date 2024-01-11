package com.example.custombar

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.custombar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding
   lateinit  var adapter_power : MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPower.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter_power = MyAdapter(20,10)
        binding.rvPower.adapter = adapter_power

        binding.btnStartAnimation.setOnClickListener {
            startAnimation()
        }

    }

    fun startAnimation(){
        val resId: Int = R.anim.layout_animation_left_to_right
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        binding.rvPower.layoutAnimation = animation;
        adapter_power.notifyDataSetChanged()
    }


}