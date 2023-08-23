package com.app.mymvpapp.util

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.app.mymvpapp.di.component.DaggerMyComponent
import com.app.mymvpapp.di.component.MyComponent
import com.app.mymvpapp.di.modules.DaggerModule
import timber.log.Timber

class MyApplication : MultiDexApplication() {

    lateinit var myComponent: MyComponent

    override fun onCreate() {
        super.onCreate()

        myComponent = DaggerMyComponent.builder()
            .daggerModule(DaggerModule(
                this
            )).build()

        //---------Timber object build-----------
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}