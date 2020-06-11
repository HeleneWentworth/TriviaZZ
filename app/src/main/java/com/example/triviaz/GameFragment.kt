package com.example.triviaz

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.triviaz.databinding.FragmentGameBinding
import com.example.triviaz.databinding.FragmentHomeBinding


class GameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        binding.submitButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_homeFragment)
        )

        return binding.root
    }

}