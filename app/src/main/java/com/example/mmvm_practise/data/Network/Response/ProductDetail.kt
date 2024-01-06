package com.example.mmvm_practise.data.Network.Response

import Product
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("jsonschema2pojo")
class ProductDetail {
    @SerializedName("products")
    @Expose
    var products: List<Product>? = null
    @SerializedName("total")
    @Expose
    var total:Number? = null
    @SerializedName("skip")
    @Expose
    var skip:Number? = null
    @SerializedName("limit")
    @Expose
    var limit:Number? = null

}