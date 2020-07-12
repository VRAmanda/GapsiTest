package com.example.gapsitest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class ProductViewModel (): ViewModel() {

    val repository: Repository = Repository()

    fun resultListProduct(search: String) = liveData(Dispatchers.IO) {
        try {
            val listProduct = repository.getList(search)
            emit(listProduct.plpResults.records)
        } catch (e: Exception) {
            Log.i("ViewModel", e.message.toString())
        }
    }
}