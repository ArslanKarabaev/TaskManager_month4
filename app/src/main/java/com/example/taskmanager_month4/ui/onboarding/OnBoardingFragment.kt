package com.example.taskmanager_month4.ui.onboarding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskmanager_month4.data.local.Pref
import com.example.taskmanager_month4.databinding.FragmentOnboardingBinding
import com.example.taskmanager_month4.ui.onboarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private val pref by lazy {
        Pref(requireContext())
    }
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
        binding.indicator.attachTo(binding.viewPager)

    }

    private fun onClick(){
        pref.userShowed()
        findNavController().navigateUp()
    }

}