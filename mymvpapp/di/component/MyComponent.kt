package com.app.mymvpapp.di.component

import com.app.mymvpapp.di.annotations.scopes.ApplicationScope
import com.app.mymvpapp.di.modules.DaggerModule
import com.app.mymvpapp.di.modules.RetrofitModule
import com.app.mymvpapp.ui.base.BaseActivity
import dagger.Component

@ApplicationScope
@Component(modules = [DaggerModule::class,RetrofitModule::class])
interface MyComponent {

    fun inject(activity: BaseActivity)
}