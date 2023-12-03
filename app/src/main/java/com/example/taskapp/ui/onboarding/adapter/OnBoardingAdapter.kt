package com.example.taskapp.ui.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieListener
import com.example.taskapp.R
import com.example.taskapp.databinding.ItemOnboardingBinding
import com.example.taskapp.model.Onboarding


class OnBoardingAdapter(
    private val context: Context,

    private val onClick: () -> Unit,

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

            val animationView = binding.ivBoard
            val animationUrl = boarding.animationUrl

            val loadedListener = object : LottieListener<LottieComposition> {
                override fun onResult(result: LottieComposition?) {
                    result?.let {
                        animationView.setComposition(it)
                        animationView.playAnimation()
                        binding.btnStart.isVisible = adapterPosition == list.lastIndex
                        binding.skip.isVisible = adapterPosition != list.lastIndex
                    }
                }
            }
            val compositionTask = LottieCompositionFactory.fromRawRes(context, boarding.animationUrl)
            compositionTask.addListener(loadedListener)

            binding.skip.setOnClickListener { onClick.invoke() }
            binding.btnStart.setOnClickListener { onClick.invoke() }
        }
    }

}