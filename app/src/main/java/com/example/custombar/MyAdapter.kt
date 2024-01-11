package com.example.custombar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.custombar.databinding.RecyclerviewItemBinding

class MyAdapter(val maxValue: Int, val value: Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
     private val ITEM_COUNT = 44

    class ViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val binding = holder.binding

        val coefficient: Double = ITEM_COUNT.toDouble() / maxValue.toDouble()
        val border = (value * coefficient).toInt() - 1

        when {
            value == 0 -> {
                updateView(binding.image, R.drawable.bar_8dp, 0.25f)
            }

            value > maxValue -> {
                if (position == itemCount - 1) {
                    updateView(binding.image, R.drawable.bar_12dp, 1.0f)
                } else {
                    updateView(binding.image, R.drawable.bar_8dp, 1.0f)
                }
            }

            position < border -> {
                updateView(binding.image, R.drawable.bar_8dp, 1.0f)
            }

            position == border -> {
                updateView(binding.image, R.drawable.bar_12dp, 1.0f)
            }

            else -> {
                updateView(binding.image, R.drawable.bar_8dp, 0.25f)
            }
        }
    }

    private fun updateView(imageView: ImageView, imageResource: Int, alpha: Float) {
        imageView.setImageResource(imageResource)
        imageView.alpha = alpha
    }

}