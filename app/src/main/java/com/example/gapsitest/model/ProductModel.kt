package com.example.gapsitest.model

import com.google.gson.annotations.SerializedName
data class ProductModel (
    var skuRepositoryId : String? = null,
    var productDisplayName : String? = null,
    var listPrice : String? = null,
    var smImage : String? = null
)
