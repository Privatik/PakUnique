package com.unique.pak.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.unique.pak.R

inline fun <reified F : Fragment> FragmentActivity.showFragment(){
    supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace<F>(R.id.content)
    }
}