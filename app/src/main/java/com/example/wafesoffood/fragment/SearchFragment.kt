package com.example.wafesoffood.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wafesoffood.R
import com.example.wafesoffood.adapter.MenuAdapter
import com.example.wafesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
   private lateinit var binding: FragmentSearchBinding
   private lateinit var adapter: MenuAdapter
   private val originalMenuFoodName = listOf("burger","sandwitch","momo","coffe","salmon","gurame","fried chicken","burger","sandwitch","momo","coffe","salmon","gurame","fried chicken")
   private val originalMenuItemPrice = listOf("$5","$7","$8","$10","$9","$8","$7","$5","$7","$8","$10","$9","$8","$7")
   private val originalMenuImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuFoodPrice = mutableListOf<String>()
    private val filterMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenuFoodName,filterMenuFoodPrice,filterMenuFoodImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        // set up for search view
        setUpSearchView()
        //show all menu item
        showAllMenu()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        filterMenuFoodName.addAll(originalMenuFoodName)
        filterMenuFoodPrice.addAll(originalMenuItemPrice)
        filterMenuFoodImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuFoodPrice.clear()
        filterMenuFoodImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuFoodPrice.add(originalMenuItemPrice[index])
                filterMenuFoodImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()

    }

    companion object {
    }
}