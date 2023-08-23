package com.app.mymvpapp.ui.main.view.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mymvpapp.DataPOJO
import com.app.mymvpapp.R
import com.app.mymvpapp.data.repositories.DataRepo
import com.app.mymvpapp.databinding.ActivityMainBinding
import com.app.mymvpapp.ui.base.BaseActivity
import com.app.mymvpapp.ui.main.contract.DataContract
import com.app.mymvpapp.ui.main.presenter.DataPresenter
import com.app.mymvpapp.ui.main.view.adapters.DataAdapter
import com.app.mymvpapp.util.Constants
import com.app.mymvpapp.utils.extensions.isNetworkActive
import com.app.mymvpapp.utils.extensions.toast

class DataActivity : BaseActivity() , DataContract, View.OnClickListener {

    lateinit var binding : ActivityMainBinding
    lateinit var dataPresenter: DataPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialization()
        onClickListeners()
        fetchData()

    }

    private fun fetchData() {
        if (this.isNetworkActive()){
            dataPresenter.getData(6)
        }else {
            this.toast(Constants.NoInternetText)
        }
    }

    private fun onClickListeners() {

        binding.btnGet.setOnClickListener(this)
        binding.btnSave.setOnClickListener(this)
    }

    private fun initialization() {
        dataPresenter = DataPresenter(DataRepo(retrofit),this)
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(this)
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun showError(errorMsg: String) {
        this.toast(errorMsg)
    }

    override fun showResponse(data: DataPOJO) {
        binding.recyclerViewUsers.adapter = DataAdapter(data)
    }

    override fun onClick(v: View?) {
        when(v?.id) {

            R.id.btnGet -> {
                binding.outputField.text = sharedPreferences.getString(Constants.SharedPrefData)
            }

            R.id.btnSave -> {
                sharedPreferences.saveString(Constants.SharedPrefData,binding.inputField.text.trim().toString())
            }

        }
    }
}