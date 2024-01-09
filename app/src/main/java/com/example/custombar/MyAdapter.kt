package com.example.custombar

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.custombar.databinding.RcItemBinding

class MyAdapter(val maxValue: Int, val value: Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    val ITEM_COUNT = 44

    class ViewHolder(val binding: RcItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RcItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val y: Double = ITEM_COUNT.toDouble() / maxValue.toDouble()
        val border = (value * y).toInt()-1

        Log.e("hata","${y} - ${border} - ${position}")

        if (value == 0) {
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
            holder.binding.image.alpha = 0.25f
        } else if (position < border) {
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
        } else if (position == border) {
            holder.binding.image.setImageResource(R.drawable.bar_12dp)
        } else {
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
            holder.binding.image.alpha = 0.25f
        }

    }


}