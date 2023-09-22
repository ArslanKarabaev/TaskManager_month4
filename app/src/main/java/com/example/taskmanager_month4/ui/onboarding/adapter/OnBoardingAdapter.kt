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
        OnBoarding("https://thumbs.dreamstime.com/b/%D0%BA%D0%BE%D0%BD%D1%86%D0%B5%D0%BF%D1%86%D0%B8%D1%8F-%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D1%8C%D0%BD%D0%BE%D0%B9-%D1%82%D0%BE%D1%80%D0%B3%D0%BE%D0%B2%D0%BB%D0%B8-%D0%B2-%D1%81%D0%BE%D0%B2%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D0%BE%D0%BC-%D0%BF%D0%BB%D0%BE%D1%81%D0%BA%D0%BE%D0%BC-%D0%B4%D0%B8%D0%B7%D0%B0%D0%B9%D0%BD%D0%B5-%D0%B6%D0%B5%D0%BD%D1%89%D0%B8%D0%BD%D0%B0-230895711.jpg",
            "Покупай не выходя из дома", "Выбирай любой магазин и совершай покупки онлайн "),
        OnBoarding("https://www.obyavleniya-moskva.ru/components/com_djclassifieds/images/profile/1/1070_e4rqbp2npq52i38w2zj3tqf8pxkp3-rncr0z50n1kyfwosdhimtexsxcggzbl_u7egtaln-jom6cyqiwru5fskwz.jpg",
            "Доставка", "Укажи адресс доставки и мы привезем тебе твои новые покупки"),
        OnBoarding("https://proftest.me/wp-content/uploads/2020/07/what-is-your-happiness.jpg",
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