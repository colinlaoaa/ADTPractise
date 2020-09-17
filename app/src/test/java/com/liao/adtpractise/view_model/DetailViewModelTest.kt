package com.liao.adtpractise.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.liao.adtpractise.model.Result
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    lateinit var detailViewModel: DetailViewModel
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setup(){
        detailViewModel = DetailViewModel()
    }

    @Test
    fun getItemInfo_test(){
        var item:Result = Result()
        item.id = "test"
        detailViewModel.getItemInfo(item)
        Assert.assertEquals(item.id, detailViewModel.myItem.get()?.id)


    }
}