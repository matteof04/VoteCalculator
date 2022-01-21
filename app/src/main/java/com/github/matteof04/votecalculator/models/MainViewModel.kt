@file:Suppress("LocalVariableName", "LocalVariableName", "LocalVariableName", "LocalVariableName")

package com.github.matteof04.votecalculator.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val ptGet = MutableLiveData<String>()
    val ptMax = MutableLiveData<String>()
    val mkMin = MutableLiveData<String>()
    val mkMax = MutableLiveData<String>()
    private val _mark = MutableLiveData<String>()
    val mark: LiveData<String>
        get() = _mark
    init {
        mkMin.value = "1"
    }
    fun calculate(){
        val _ptGet = ptGet.value.orEmpty().toIntOrZero()
        val _ptMax = ptMax.value.orEmpty().toIntOrZero()
        val _mkMin = mkMin.value.orEmpty().toIntOrZero()
        val _mkMax = mkMax.value.orEmpty().toIntOrZero()
        _mark.value = try {
            ((_mkMax - _mkMin) * _ptGet / _ptMax + _mkMin).toString()
        }catch (e : Exception){
            0.toString()
        }
    }
}

fun String.toIntOrZero() : Int{
    return try {
        this.toInt()
    }catch (e : Exception){
        0
    }
}