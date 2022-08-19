package com.example.basefragment.Fragments.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.basefragment.Fragments.Base.BaseFragmentWithViewModel
import com.example.basefragment.databinding.FragmentHomeBinding

class HomeFragment : BaseFragmentWithViewModel<FragmentHomeBinding, HomeViewModel>() {

    override var useSharedViewModel: Boolean = false

    override fun getViewModelClass() = HomeViewModel::class.java

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun listeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWelcomeFragment())
        }
    }

}