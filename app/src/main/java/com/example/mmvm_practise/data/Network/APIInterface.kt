package com.example.mmvm_practise.data.Network

import Product
import android.telecom.Call.Details
import com.example.mmvm_practise.data.Database.User
import com.example.mmvm_practise.data.Network.Response.ProductDetail
import com.example.mmvm_practise.data.Network.Response.UserDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIInterface {
//    @FormUrlEncoded
//    @POST("auth/login")
//    fun loginUser(@Field("username") username:String, @Field("password") password:String): Call<UserDetail>

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun loginUser(@Field("username") username:String, @Field("password") password:String): Response<UserDetail>

    @GET("products")
    suspend fun getAllDetail():Response<ProductDetail>

    @GET("products/{prodId}")
    suspend fun getSingleProduct(@Path("prodId") prodID:Number):Response<Product>
}