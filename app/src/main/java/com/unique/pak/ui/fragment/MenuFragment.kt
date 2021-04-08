package com.unique.pak.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.unique.pak.R
import com.unique.pak.databinding.FragmentMenuBinding
import com.unique.pak.ui.dialog.SelectingGameDialog

class MenuFragment: Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        binding.play.setOnClickListener {
           SelectingGameDialog()
               .show(childFragmentManager,"modeGame")
        }


        binding.rules.setOnClickListener {
            Log.e("Rules","onClick binding")
           activity?.showFragment<RulesFragment>()
        }


        binding.setting.setOnClickListener {
            activity?.showFragment<SettingFragment>()
        }
    }

}