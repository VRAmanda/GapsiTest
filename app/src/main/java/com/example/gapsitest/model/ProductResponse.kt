package com.example.gapsitest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("records")
    @Expose
    var records: List<ProductModel>
)
