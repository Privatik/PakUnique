package com.unique.pak.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.unique.pak.R
import com.unique.pak.databinding.FragmentSettingBinding
import com.unique.pak.viewmodel.SettingViewModel

class SettingFragment: Fragment(R.layout.fragment_setting) {
    private lateinit var binding: FragmentSettingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)
        val model : SettingViewModel by viewModels()
        binding.viewmodel = model

        binding.close.setOnClickListener {
            activity?.showFragment<MenuFragment>()
        }

        binding.soundChange.apply {
            setOnClickListener {
                binding.viewmodel?.apply {
                    isSound = !isSound
                    setImageResource(drawIcon(isSound))
                }
            }
        }

        binding.vibroChange.apply {
            setOnClickListener {
                binding.viewmodel?.apply {
                    Log.e("Vibro","click isVibro $isVibro")
                    isVibro = !isVibro
                    setImageResource(drawIcon(isVibro))
                }
            }
        }
    }

    private fun drawIcon(isComplete: Boolean): Int = if (isComplete) R.drawable.complete else R.drawable.cancel
}