package com.unique.pak.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.unique.pak.R
import com.unique.pak.databinding.FragmentRulesBinding

class RulesFragment: Fragment(R.layout.fragment_rules) {
    private lateinit var binding: FragmentRulesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRulesBinding.bind(view)

        binding.close.setOnClickListener {
            activity?.showFragment<MenuFragment>()
        }
    }
}