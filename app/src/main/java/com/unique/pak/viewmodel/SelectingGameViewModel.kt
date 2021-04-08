package com.unique.pak.viewmodel

import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel

class SelectingGameViewModel: ViewModel() {
    private var _mode = Mode.EASY
    private var _time = Time.THIRD

    var mode =  _mode
    var time =  _time
}

enum class Mode{
    EASY,
    MEDIUM,
    HARD
}

enum class Time(val milisec: Int){
    THIRD(30000),
    SIXTY(60000)
}

fun MutableList<Button>.currentdraw(currentPosition: Int){
    forEachIndexed { index, textView ->
        if (currentPosition == index){
            textView.setTextColor(Color.BLACK)
        }
        else{
            textView.setTextColor(Color.WHITE)
        }
    }
}