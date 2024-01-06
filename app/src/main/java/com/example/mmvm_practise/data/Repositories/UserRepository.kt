package com.example.mmvm_practise.data.Repositories

import Product
import android.telecom.Call.Details
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mmvm_practise.data.Database.User
import com.example.mmvm_practise.data.Network.Response.ProductDetail
import com.example.mmvm_practise.data.Network.Response.UserDetail
import com.example.mmvm_practise.data.Network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    val service = RetrofitClient().getAPIService()
    suspend fun userLogin(email:String, password:String): Response<UserDetail>? {
        val response: Response<UserDetail>? = service?.loginUser(email, password)
        return response
//        val loginRespo = MutableLiveData<String>()
//
//        val call = RetrofitClient().getAPIService()?.loginUser(email, password)
//        call?.enqueue(object: Callback<UserDetail> {
//            override fun onResponse(call: Call<UserDetail>, response: Response<UserDetail>) {
//                val userDetail: UserDetail? = response.body()
//                    loginRespo.value = userDetail?.firstName
//
//            }
//
//            override fun onFailure(call: Call<UserDetail>, t: Throwable) {
//                loginRespo.value = t.message
//            }
//        }
//        )
//        return loginRespo

    }
    suspend fun getAllProdDetail():Response<ProductDetail>?{
        val response:Response<ProductDetail>? = service?.getAllDetail()
        return response
    }
    suspend fun getSingleProduct(id:Number):Response<Product>?{
        val response:Response<Product>? = service?.getSingleProduct(id)
        return response
    }
}