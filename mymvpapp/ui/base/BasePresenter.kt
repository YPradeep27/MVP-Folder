package com.app.mymvpapp.ui.base

import com.app.mymvpapp.data.repositories.DataRepo

open class BasePresenter(var dataRepo: DataRepo) {

  //  lateinit var dataRepo: DataRepo

    fun provideDataRepo(dataRepo: DataRepo) {
        this.dataRepo = dataRepo
    }
}