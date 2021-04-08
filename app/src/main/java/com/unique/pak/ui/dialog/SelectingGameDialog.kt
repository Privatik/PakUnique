package com.unique.pak.ui.dialog

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.unique.pak.R
import com.unique.pak.databinding.DialogSelectingGameBinding
import com.unique.pak.ui.activity.PlayFieldActivity
import com.unique.pak.viewmodel.Mode
import com.unique.pak.viewmodel.SelectingGameViewModel
import com.unique.pak.viewmodel.Time
import com.unique.pak.viewmodel.currentdraw

class SelectingGameDialog: DialogFragment(R.layout.dialog_selecting_game) {
    private lateinit var binding: DialogSelectingGameBinding
    private val listTextMode: MutableList<Button> = mutableListOf()
    private val listTextTime: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        binding = DialogSelectingGameBinding.bind(view)
        val model : SelectingGameViewModel by viewModels()
        binding.viewmodel = model

        binding.easyText.setTextColor(Color.BLACK)
        binding.timeThirdText.setTextColor(Color.BLACK)

        listTextMode.add(binding.easyText)
        listTextMode.add(binding.mediumText)
        listTextMode.add(binding.hardText)

        listTextTime.add(binding.timeThirdText)
        listTextTime.add(binding.timeSixtyText)

        modeSetting(Mode.EASY, binding.easyText,  binding.imageEasy, 0)
        modeSetting(Mode.MEDIUM, binding.mediumText,  binding.imageMedium, 1)
        modeSetting(Mode.HARD, binding.hardText,  binding.imageHard, 2)

        timeSetting(Time.THIRD,  binding.timeThirdText, binding.imageTimeThird, 0)
        timeSetting(Time.SIXTY,  binding.timeSixtyText, binding.imageTimeSixty, 1)

        binding.start.setOnClickListener {
            startActivity(PlayFieldActivity.newInstance(requireContext(),binding.viewmodel!!.time.milisec))
        }
    }

    fun modeSetting(mode: Mode, button: Button, imageView: ImageView, currentPosition: Int){
        val listener = View.OnClickListener {
            if (binding.viewmodel?.mode == mode) return@OnClickListener
            listTextMode.currentdraw(currentPosition)
            binding.viewmodel?.mode = mode
            Log.e("Mode","${binding.viewmodel?.mode}")
        }

        button.setOnClickListener(listener)
        imageView.setOnClickListener(listener)
    }

    fun timeSetting(time: Time, button: Button, imageView: ImageView, currentPosition: Int){
        val listener = View.OnClickListener {
            if (binding.viewmodel?.time == time) return@OnClickListener
            listTextTime.currentdraw(currentPosition)
            binding.viewmodel?.time = time
            Log.e("Time","${binding.viewmodel?.time}")
        }

        button.setOnClickListener(listener)
        imageView.setOnClickListener(listener)
    }
}