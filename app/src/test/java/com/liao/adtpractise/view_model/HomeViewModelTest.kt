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
class HomeViewModelTest {

    lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setup(){
        homeViewModel = HomeViewModel()
    }


    @Test
    fun getItemDetail_test(){
        var item:Result = Result()
        item.id = "test"
        homeViewModel.getItemDetail(item)
        homeViewModel.observeItemClicked().observeForever {
            Assert.assertEquals(item.id, it.id)
        }
    }

}