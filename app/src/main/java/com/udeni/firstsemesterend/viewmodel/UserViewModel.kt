package com.udeni.firstsemesterend.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udeni.firstsemesterend.R

class UserViewModel : ViewModel() {
    private val _username = MutableLiveData<String>("")
    val username: LiveData<String> get() = _username

    fun init(sharedPreferences: SharedPreferences) {
        _username.value = sharedPreferences.getString(R.string.username.toString(), "")?.toString()
    }
}