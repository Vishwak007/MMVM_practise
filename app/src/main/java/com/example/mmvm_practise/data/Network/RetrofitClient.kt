package com.example.mmvm_practise.data.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    var service:APIInterface?=null
    constructor(){
        val retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(APIInterface::class.java)
    }

    fun getAPIService():APIInterface?{
        return service
    }
}