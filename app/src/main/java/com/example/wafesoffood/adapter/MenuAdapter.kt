package com.example.wafesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wafesoffood.databinding.MenuItemBinding

class MenuAdapter(private val MenuItemsName: MutableList<String>,private val MenuItemPrice: MutableList<String>,private val MenuImage: MutableList<Int>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemsName.size


    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = MenuItemsName[position]
                menuPrice.text = MenuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])

            }
        }
    }

}