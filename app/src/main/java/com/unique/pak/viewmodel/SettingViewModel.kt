package com.unique.pak.viewmodel

import androidx.lifecycle.ViewModel

open class SettingViewModel: ViewModel() {
    private var _isVibro = true
    private var _isSound = false

    var isVibro = _isVibro
    var isSound = _isSound
}