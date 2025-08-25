package com.example.wafesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wafesoffood.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>,private val cartItemsPrice:MutableList<String>,private val cartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemsQuantities = IntArray(cartItems.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
       val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemsQuantities[position]
                cardfoodName.text=cartItems[position]
                cardItemPrice.text=cartItemsPrice[position]
                cardImage.setImageResource(cartImage[position])
                cardItemQuantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    deceaseQuantity(position)

                }

                plusButtton.setOnClickListener {
                    increaseQuantity(position)
                }

                deletedButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION)
                        deletedItem(itemPosition)
                }

            }
        }

        private fun increaseQuantity(position: Int){
            if (itemsQuantities[position] < 10){
                itemsQuantities[position]++
                binding.cardItemQuantity.text = itemsQuantities[position].toString()
            }
        }

        private fun deceaseQuantity(position: Int){
            if (itemsQuantities[position] > 1){
                itemsQuantities[position]--
                binding.cardItemQuantity.text = itemsQuantities[position].toString()
            }
        }



        private fun deletedItem(position: Int){
            cartItems.removeAt(position)
            cartImage.removeAt(position)
            cartItemsPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItems.size)
        }

    }
}