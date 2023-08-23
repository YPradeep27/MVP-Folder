package com.app.mymvpapp.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.app.mymvpapp.di.annotations.scopes.ApplicationScope
import com.app.mymvpapp.di.component.MyComponent
import com.app.mymvpapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
class DaggerModule(private val context: Context) {

    @Provides
    @ApplicationScope
    fun provideContext() : Context {
        return context
    }

    @Provides
    @ApplicationScope
    fun provideSharedPreference() : SharedPreferences{
        return context.getSharedPreferences(Constants.Shared_Pref,Context.MODE_PRIVATE)
    }
}