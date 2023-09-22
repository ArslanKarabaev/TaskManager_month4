package com.example.taskmanager_month4.ui.onboarding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskmanager_month4.R
import com.example.taskmanager_month4.databinding.FragmentOnboardingBinding
import com.example.taskmanager_month4.ui.onboarding.adapter.OnBoardingAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        val indicator = view.findViewById<WormDotsIndicator>(R.id.indicator)
        indicator.attachTo(binding.viewPager)

    }

    private fun onClick(){
        findNavController().navigateUp()
    }

}