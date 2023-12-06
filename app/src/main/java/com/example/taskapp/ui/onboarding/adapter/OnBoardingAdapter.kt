package com.example.taskapp.ui.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.R
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.model.Onboarding


class OnBoardingAdapter(
    private val onClick: () -> Unit
    ) : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf<Onboarding>(
        Onboarding(
            R.raw.ppa,
            "Fresh food",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        Onboarding(
            R.raw.animation1,
            "Fresh food",
            "Lorem impsum dolor sit amet, consectetuer adipiscing elit.Aenean commodo ligula eget dolor"
        ),
        Onboarding(
            R.raw.animation1,
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
        return OnBoardingViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding, context: Context) :
        ViewHolder(binding.root) {

        fun bind(boarding: Onboarding) {
            binding.title.text = boarding.title
            binding.desc.text = boarding.desc
            boarding.animationUrl?.let { binding.ivBoard.setAnimation(it) }

            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.skip.isVisible = adapterPosition != list.lastIndex
            binding.skip.setOnClickListener { onClick() }
            binding.btnStart.setOnClickListener { onClick() }
        }
    }
}