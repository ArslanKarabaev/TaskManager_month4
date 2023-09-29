package com.example.taskmanager_month4.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager_month4.databinding.ItemOnboardingBinding
import com.example.taskmanager_month4.model.OnBoarding
import com.bumptech.glide.Glide as Glide

class OnBoardingAdapter(private val onClick:() -> Unit) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding("https://cdn-icons-png.flaticon.com/512/4345/4345573.png",
            "Покупай не выходя из дома", "Выбирай любой магазин и совершай покупки онлайн "),
        OnBoarding("https://static.tildacdn.com/tild6634-6635-4663-a432-653436336236/picto61_1_1.png",
            "Доставка", "Укажи адресс доставки и мы привезем тебе твои новые покупки"),
        OnBoarding("https://img.freepik.com/premium-vector/success-at-the-top-leadership-to-reach-business-goal-career-success-or-assigned-tasks-contest-winner-a-young-man-or-businessman-raises-a-flag-on-a-high-mountain-peak_327176-1051.jpg",
            "Начало пути", "Так давай же начнем исследовать..."),
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
             binding.btnSkip.setOnClickListener{
                 onClick()
             }
             binding.btnStart.isVisible = adapterPosition == data.lastIndex
             binding.btnSkip.isVisible = adapterPosition != data.lastIndex
             binding.tvTitle.text = onBoarding.title
             binding.tvDesc.text = onBoarding.desc
             Glide.with(binding.imgOnboard).load(onBoarding.image).into(binding.imgOnboard)

         }

    }
}