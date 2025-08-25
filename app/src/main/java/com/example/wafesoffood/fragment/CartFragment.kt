package com.example.wafesoffood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wafesoffood.R
import com.example.wafesoffood.adapter.CartAdapter
import com.example.wafesoffood.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var  binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cardFoodName = listOf("burger","sandwitch","momo","coffe","salmon","gurame","fried chicken")
        val cardItemPrice = listOf("$5","$7","$8","$10","$9","$8","$7")
        val cardImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        val adapter = CartAdapter(ArrayList(cardFoodName),ArrayList(cardItemPrice),ArrayList(cardImage))
        binding.cartRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerview.adapter = adapter
        return binding.root
    }

    companion object {
    }
}