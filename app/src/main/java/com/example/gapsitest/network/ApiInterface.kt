package com.example.gapsitest.network

import android.content.Context
import androidx.multidex.BuildConfig

import com.example.gapsitest.model.ProductResponse
import com.example.gapsitest.model.RootResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("plp?force-plp=true")
    suspend fun getProductsValue( @Query("search-string") search: String) : RootResponse

    companion object {
        fun  initService(context: Context? = null) : ApiInterface
        {
            var okHttpClient = CacheProduct.clienHttp(context)

            return Retrofit.Builder()
                .baseUrl("https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/")
                .addConverterFactory(GsonConverterFactory.create())

                .client(okHttpClient)
                .build()
                .create(ApiInterface::class.java)
        }
    }
}