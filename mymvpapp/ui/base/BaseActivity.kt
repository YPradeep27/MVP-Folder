package com.app.mymvpapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.mymvpapp.di.modules.HelperSharedPreferences
import com.app.mymvpapp.util.MyApplication
import com.app.mymvpapp.util.network.RetrofitService
import javax.inject.Inject

// data class User(val firstName: String , val lastName : String ,val age : Int)

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferences: HelperSharedPreferences

    @Inject
    lateinit var retrofit: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).myComponent.inject(this)

/*
        val (x,y,z) = User("John", "Doe", 25)


        if (x.length == 4){
            print(y)
        }*/


    }
}