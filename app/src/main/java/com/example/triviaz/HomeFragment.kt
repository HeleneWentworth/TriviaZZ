package com.example.triviaz

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triviaz.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), OnCategoryItemClickListerner {

    private val viewModel: GameViewModel by  activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.catButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_gameFragment)
        )
        val categoryList = viewModel.generateDummyList(6)
        binding.categoryList.adapter = CategoryAdapter(viewModel.categories, this)
        binding.categoryList.layoutManager = LinearLayoutManager(context)
        binding.categoryList.setHasFixedSize(true)

        return binding.root
    }

    override fun onCategoryClick(category: CategoryItem, position: Int, view: View) {
       Toast.makeText(context, "The category text ${category.text} category ID:${category.id}", Toast. LENGTH_SHORT).show()
        viewModel.setupGame(category.id)
        view.findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
    }

}