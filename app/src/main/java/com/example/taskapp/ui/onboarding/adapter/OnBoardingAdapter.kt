package com.example.taskapp.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.model.Onboarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<Onboarding>(
        Onboarding(
            "https://cdni.iconscout.com/illustration/premium/thumb/future-technology-3391260-2937867.png",
            "Fresh food",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        Onboarding(
            "https://cdni.iconscout.com/illustration/premium/thumb/characters-integrating-with-audience-on-social-media-platform-8528192-6763222.png",
            "Fast Delivery",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        Onboarding(
            "https://cdni.iconscout.com/illustration/premium/thumb/easy-payment-3391270-2937873.png",
            "Easy Payment",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        )

    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnBoardingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(boarding: Onboarding) {
            binding.tvTitle.text = boarding.tv_title
            binding.tvDesc.text = boarding.tv_desc
            Glide.with(binding.root)
                .load(boarding.image)
                .into(binding.ivBoard)
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.skip.isVisible = adapterPosition != list.lastIndex
            binding.skip.setOnClickListener { onClick() }
            binding.btnStart.setOnClickListener { onClick() }
        }
    }
}
