package com.app.mymvpapp.di.modules

import android.content.SharedPreferences
import javax.inject.Inject

class HelperSharedPreferences
@Inject
constructor(private var sharedPreferences: SharedPreferences) {

    fun saveString(key : String, value : String) {
       val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
        editor.commit()
    }

    fun saveInt(key: String,value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
        editor.commit()
    }

    fun getString(key: String) : String?{
        return sharedPreferences.getString(key,"")
    }
}