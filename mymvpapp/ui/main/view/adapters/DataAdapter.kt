package com.app.mymvpapp.ui.main.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mymvpapp.DataPOJO
import com.app.mymvpapp.databinding.ContentUsersItemsBinding

class DataAdapter(val data : DataPOJO?) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {

        val binding : ContentUsersItemsBinding = ContentUsersItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {

        data?.data?.let {
            holder.binding.apply {
                txtvwId.text = it.get(position).id.toString()
                txtvwFirstName.text = it.get(position).first_name
                txtvwLastName.text = it.get(position).last_name
            }
        }

        holder.binding.cardviewItems.setOnClickListener {

        }

    }
    inner class ViewHolder (val binding: ContentUsersItemsBinding)  : RecyclerView.ViewHolder(binding.root)


    override fun getItemCount(): Int {
        return data?.data?.size!!
    }

}