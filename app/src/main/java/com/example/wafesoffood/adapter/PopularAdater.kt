package com.example.wafesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wafesoffood.databinding.PopularItemBinding

class PopularAdater (private val items:List<String>, private val price:List<String>, private val image:List<Int>): RecyclerView.Adapter<PopularAdater.PoupolerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoupolerViewHolder {
     return PoupolerViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PoupolerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PoupolerViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageView6
        fun bind(item: String,price: String, images: Int) {
            binding.foodNamePopular.text = item
            binding.pricePopular.text = price
            imagesView.setImageResource(images)
        }

    }
}