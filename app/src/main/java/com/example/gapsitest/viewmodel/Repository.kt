package com.example.gapsitest.viewmodel

import com.example.gapsitest.network.ApiInterface

public class Repository {

    val result: ApiInterface = ApiInterface.initService()
    //suspend fun getList(search: String) = result.getProductsWithValue(search)

    suspend fun getList(search: String) = result.getProductsValue(search)

}