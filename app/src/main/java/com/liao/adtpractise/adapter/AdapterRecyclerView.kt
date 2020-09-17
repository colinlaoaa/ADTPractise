package com.liao.adtpractise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liao.adtpractise.databinding.NewRowBinding
import com.liao.adtpractise.model.Result
import com.liao.adtpractise.view_model.HomeViewModel

class AdapterRecyclerView(private val context: Context, private var list: List<Result>,private var viewModel: HomeViewModel) :
    RecyclerView.Adapter<AdapterRecyclerView.MyViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val binding = NewRowBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewModel(binding)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun refreshList(mList: List<Result>) {
        list = mList
        notifyDataSetChanged()
    }

    inner class MyViewModel(private val binding: NewRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.item = item
            binding.adapter = this@AdapterRecyclerView
            binding.viewModel = viewModel
        }
    }

}