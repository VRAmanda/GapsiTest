package com.example.gapsitest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RootResponse (

    @SerializedName("plpResults")
    @Expose
    var plpResults: ProductResponse
)

