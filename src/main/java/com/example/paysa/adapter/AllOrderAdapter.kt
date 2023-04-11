package com.example.paysa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paysa.databinding.AllOrderItemLayoutBinding
import com.example.paysa.model.AllOrderModel

class AllOrderAdapter(val list: List<AllOrderModel>, val context: Context) :
    RecyclerView.Adapter<AllOrderAdapter.AllOrderViewHolder>() {

    inner class AllOrderViewHolder(val binding: AllOrderItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllOrderViewHolder {
        val binding =
            AllOrderItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllOrderViewHolder, position: Int) {
        holder.binding.productTitle.text = list[position].name.toString()
        holder.binding.productPrice.text = list[position].price.toString()


        when (list[position].status) {
            "Ordered" -> {
                holder.binding.productStatus.text = "Ordered"
            }
            "Dispatched" -> {
                holder.binding.productStatus.text = "Dispatched"

            }
            "Delivered" -> {
                holder.binding.productStatus.text = "Delivered"

            }
            "Canceled" -> {
                holder.binding.productStatus.text = "Canceled"
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

}