package com.unique.pak.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unique.pak.R
import com.unique.pak.ui.fragment.MenuFragment
import com.unique.pak.ui.fragment.showFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showFragment<MenuFragment>()
    }
}