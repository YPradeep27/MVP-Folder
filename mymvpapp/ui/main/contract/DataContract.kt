package com.app.mymvpapp.ui.main.contract

import com.app.mymvpapp.DataPOJO

interface DataContract {

    fun showLoading()
    fun hideLoading()
    fun showError(errorMsg : String)
    fun showResponse(data : DataPOJO)
}