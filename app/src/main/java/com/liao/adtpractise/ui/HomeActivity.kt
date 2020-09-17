package com.liao.adtpractise.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liao.adtpractise.R
import com.liao.adtpractise.adapter.AdapterRecyclerView
import com.liao.adtpractise.model.Result
import com.liao.adtpractise.view_model.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel
    lateinit var mAdapter: AdapterRecyclerView
    var upPage: String? = null
    var downPage: String? = null
    var mList: List<Result> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mAdapter = AdapterRecyclerView(this, mList, viewModel)

        getData()
        init()
        jumpToDetail()
    }

    private fun jumpToDetail() {
        viewModel.observeItemClicked().observe(this, Observer {
            if (it!=null){
                var myIntent = Intent(this,DetailActivity::class.java)
                myIntent.putExtra(Result.KEY, it)
                startActivity(myIntent)
            }
        })
    }

    private fun getData() {
        viewModel.callAPIGetList("1")
        viewModel.observeLiveDate().observe(this, Observer {
            if (it != null) {
                mList = it.results
                mAdapter.refreshList(mList)
                upPage = it.info.prev?.get(it.info.prev.lastIndex).toString()
                downPage = it.info.next?.get(it.info.next.lastIndex).toString()
            }
        })
    }

    private fun init() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = mAdapter
        recycler_view.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                //last item in screen's position
                val lastVisibleItemPosition = layoutManager!!.findLastVisibleItemPosition()
                //first item in screen's position
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                //total number of item in screen
                val visibleItemCount = layoutManager.childCount
                //total number of item in recyclerview
                val totalItemCount = layoutManager.itemCount
                if (visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1) {
                    Toast.makeText(applicationContext, "bottom", Toast.LENGTH_SHORT).show()
                    if (downPage != null) {
                        viewModel.callAPIGetList(downPage!!)
                    }
                }
                if (visibleItemCount > 0 && firstVisibleItemPosition == 0) {
                    Toast.makeText(applicationContext, "top", Toast.LENGTH_SHORT).show()
                    if (upPage != null) {
                        viewModel.callAPIGetList(upPage!!)

                    }
                }
            }

        })

    }


}