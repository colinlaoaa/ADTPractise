package com.liao.adtpractise.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.liao.adtpractise.R
import com.liao.adtpractise.databinding.ActivityDetailBinding
import com.liao.adtpractise.model.Result
import com.liao.adtpractise.view_model.DetailViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var viewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.viewModel =viewModel

        init()
    }

    private fun init() {
        var i = intent
        var item = i.getSerializableExtra(Result.KEY) as Result
        viewModel.getItemInfo(item)
    }
}