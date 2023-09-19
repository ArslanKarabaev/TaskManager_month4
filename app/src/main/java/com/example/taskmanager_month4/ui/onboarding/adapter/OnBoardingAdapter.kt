package com.example.taskmanager_month4.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager_month4.databinding.ItemOnboardingBinding
import com.example.taskmanager_month4.model.OnBoarding

class OnBoardingAdapter(private val onClick:() -> Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding("", "Title 1", "Desc 1"),
        OnBoarding("", "Title 2", "Desc 2"),
        OnBoarding("", "Title 3", "Desc 3"),
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false ))
    }



    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private var binding : ItemOnboardingBinding) : ViewHolder(binding.root){
         fun bind(onBoarding : OnBoarding){
         binding.btnStart.setOnClickListener{
             onClick()
         }
             binding.btnStart.isVisible = adapterPosition == data.lastIndex
             binding.tvTitle.text = onBoarding.title
             binding.tvDesc.text = onBoarding.desc
             // TODO: bind image
         }

    }
}