package com.app.mymvpapp.ui.main.presenter

import androidx.lifecycle.MutableLiveData
import com.app.mymvpapp.DataPOJO
import com.app.mymvpapp.data.repositories.DataRepo
import com.app.mymvpapp.ui.base.BasePresenter
import com.app.mymvpapp.ui.main.contract.DataContract
import kotlinx.coroutines.*
import timber.log.Timber
import java.lang.Exception

class DataPresenter
constructor(val dataRepo: DataRepo,val view : DataContract){

   // var data : MutableLiveData<DataPOJO> = MutableLiveData()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun getData(size : Int){

        Timber.e("Size1 : ${size}")
        coroutineScope.launch{

            view.showLoading()

            Timber.e("Size2 : ${size}")

 /*           val data = dataRepo.getData(size)
            view.showResponse(data)
            view.hideLoading()*/

            try {
                val data = dataRepo.getData(size)
                view.showResponse(data)
            }
            catch (exception : Exception){
                view.showError(exception.toString())
                Timber.e("Exception Check : ${exception}")
            }
            finally {
                view.hideLoading()
            }

        }

    }
}