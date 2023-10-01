package com.enplus.energetic.ui.screen.otp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(
) : ViewModel() {

    private val _isUserAuthorized: MutableLiveData<Boolean> = MutableLiveData(true)
    val isUserAuthorized: LiveData<Boolean> get() = _isUserAuthorized

    private val _pinLength: MutableLiveData<Int> = MutableLiveData(4)
    val pinLength: LiveData<Int> get() = _pinLength

    private val _inputtedPin: MutableLiveData<String> = MutableLiveData("")

    private val _inputtedPinLength: MutableLiveData<Int> = MutableLiveData<Int>().apply {
        value = _inputtedPin.value!!.length
    }
    val inputtedPinLength: LiveData<Int> get() = _inputtedPinLength

    fun onNumberButtonClick(value: Int) {
        _inputtedPin.value += value.toString()
        _inputtedPinLength.value = _inputtedPin.value!!.length
    }

    fun onBackspaceButtonClick() {
        _inputtedPin.value = _inputtedPin.value!!.dropLast(1)
        _inputtedPinLength.value = _inputtedPin.value!!.length
    }
}
