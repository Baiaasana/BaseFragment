package com.example.basefragment.Fragments.Welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.basefragment.Fragments.Base.BaseFragment
import com.example.basefragment.R
import com.example.basefragment.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun listeners() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment())
        }

    }

    override fun init() {
    }

}