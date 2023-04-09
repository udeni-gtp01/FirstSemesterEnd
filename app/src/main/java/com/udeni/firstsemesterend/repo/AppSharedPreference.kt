package com.udeni.firstsemesterend.repo

import android.content.Context
import com.udeni.firstsemesterend.R

class AppSharedPreference(context: Context){
    private val appSharedPreference=context.getSharedPreferences(R.string.shared_pref_name.toString(), Context.MODE_PRIVATE)
    private val editor=appSharedPreference.edit()

    fun saveUser(username:String)=editor.putString(R.string.username.toString(),username).commit()
    fun getUsername():String?=appSharedPreference.getString(R.string.username.toString(),"")
}