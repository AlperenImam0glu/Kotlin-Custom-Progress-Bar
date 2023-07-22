package com.example.custombar

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.custombar.databinding.RcItemBinding

class MyAdapter(val maxValue: Int, val value: Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    val ITEM_COUNT = 44
    class ViewHolder(val binding: RcItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RcItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var x = maxValue + maxValue* 0.2
        var y = x/ITEM_COUNT
        var z = (value/y).toInt()

        if(value==0){
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
            holder.binding.image.alpha= 0.25f
        }
        else if(position < z){
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
        }else if(z == position){

            holder.binding.image.setImageResource(R.drawable.bar_12dp)
        }else{
            holder.binding.image.setImageResource(R.drawable.bar_8dp)
            holder.binding.image.alpha= 0.25f
        }

    }


}