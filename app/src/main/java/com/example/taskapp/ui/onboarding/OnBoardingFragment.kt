package com.example.taskapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.data.local.Pref
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.ui.onboarding.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator3

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val onClickListener: () -> Unit = {
            pref.onBoardingShow()
            findNavController().navigate(R.id.navigation_home)
        }

        val adapter = OnBoardingAdapter(requireContext(), onClickListener)
        binding.viewPager.adapter = adapter

        val indicator: CircleIndicator3 = binding.indicator
        indicator.setViewPager(binding.viewPager)
        return binding.root
    }

}