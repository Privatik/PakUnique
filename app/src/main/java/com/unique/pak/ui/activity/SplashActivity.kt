package com.unique.pak.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.unique.pak.R
import kotlinx.coroutines.*

class SplashActivity: AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MainActivity::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            startActivity(intent)
            finish()
        }
    }
}