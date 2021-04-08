package com.unique.pak.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unique.pak.R
import com.unique.pak.adapter.AdapterField
import com.unique.pak.databinding.ActivityPlayFieldBinding
import com.unique.pak.decoration.GridDecoration
import com.unique.pak.viewmodel.PlayFieldViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PlayFieldActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayFieldBinding
    
    companion object{
        private const val TIME = "time"

        fun newInstance(context: Context, time: Int): Intent{
            val intent = Intent(context, PlayFieldActivity::class.java)
            intent.putExtra(TIME,time)

            return intent
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_field)
        binding.lifecycleOwner = this
        val model: PlayFieldViewModel by viewModels()
        binding.viewmodel = model

        val time = intent?.getIntExtra(TIME, 30000)!!
        binding.time.text = "${time / 1000} sec"
        binding.countCoin.text = "0"

        val adapter = AdapterField(binding.countCoin)
        binding.coinField.adapter = adapter
        binding.coinField.layoutManager = GridLayoutManager(this, 6, LinearLayoutManager.VERTICAL,false)
        binding.coinField.addItemDecoration(GridDecoration(spanCount = 6, spacing = 20, includeEdge = true))


        CoroutineScope(Dispatchers.Main).launch{
            Log.e("time","$time")
            for (i in time-1000 downTo 0 step  1000) {
                delay(1000)
                Log.e("time",(i / 1000).toString())
                binding.time.text = "${i / 1000} sec"
            }
        }
    }
}